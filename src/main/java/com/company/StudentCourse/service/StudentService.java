package com.company.StudentCourse.service;

import com.company.StudentCourse.dto.StudentDTO;
import com.company.StudentCourse.entity.StudentEntity;
import com.company.StudentCourse.enums.StudentGender;
import com.company.StudentCourse.exp.AppBadRequestException;
import com.company.StudentCourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO getById(Integer id) {
        StudentEntity entity = get(id);
        StudentDTO dto = new StudentDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setLevel(entity.getLevel());
        dto.setAge(entity.getAge());
        dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public StudentEntity get(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Student not found: " + id);
        }
        return optional.get();
    }

    public StudentDTO crate(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setLevel(dto.getLevel());
        entity.setGender(dto.getGender());
        entity.setCreatedDate(dto.getCreatedDate());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
        if (dto.getAge() == null) {
            throw new AppBadRequestException("Age qani?");
        }
        if (dto.getLevel() == null || dto.getLevel().isBlank()) {
            throw new AppBadRequestException("Level qani?");
        }
        if (dto.getGender() == null) {
            throw new AppBadRequestException("Gender qani?");
        }
        studentRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<StudentDTO> getAll() {
        Iterable<StudentEntity> all = studentRepository.findAll();
        List<StudentDTO> dtoList = new LinkedList<>();

        all.forEach(studentEntity -> {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(studentEntity.getId());
            studentDTO.setName(studentEntity.getName());
            studentDTO.setSurname(studentEntity.getSurname());
            studentDTO.setLevel(studentEntity.getLevel());
            studentDTO.setAge(studentEntity.getAge());
            studentDTO.setCreatedDate(studentEntity.getCreatedDate());
            studentDTO.setGender(studentEntity.getGender());
            dtoList.add(studentDTO);
        });
        return dtoList;
    }

    public boolean update(Integer id, StudentDTO studentDTO) {
        StudentEntity entity = get(id);
        entity.setName(studentDTO.getName());
        entity.setSurname(studentDTO.getSurname());
        entity.setAge(studentDTO.getAge());
        entity.setLevel(studentDTO.getLevel());
        entity.setCreatedDate(studentDTO.getCreatedDate());
        entity.setGender(studentDTO.getGender());
        studentRepository.save(entity);
        return true;
    }

    public boolean delete(Integer id) {
        StudentEntity entity = get(id);
        studentRepository.delete(entity);
        return true;
    }


    public List<StudentDTO> getByGivenDate(LocalDate date) {

        List<StudentEntity> list = studentRepository.findByCreatedDate(date);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }


    public List<StudentDTO> getByName(String field) {
        List<StudentEntity> list = studentRepository.findByName(field);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }


    public List<StudentDTO> getBySurname(String field) {
        List<StudentEntity> list = studentRepository.findBySurname(field);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getByAge(Integer field) {
        List<StudentEntity> list = studentRepository.findByAge(field);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getByLevel(String field) {
        List<StudentEntity> list = studentRepository.findByLevel(field);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getByGender(StudentGender field) {
        List<StudentEntity> list = studentRepository.findByGender(field);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentDTO> getBetweenDates(LocalDate date, LocalDate date1) {
        List<StudentEntity> list = studentRepository.findByCreatedDateBetween(date, date1);
        List<StudentDTO> dtoList = new LinkedList<>();
        for (StudentEntity entity : list) {
            StudentDTO dto = new StudentDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(StudentGender.valueOf(entity.getGender().toString()));
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;    }
}
