package com.company.StudentCourse.service;

import com.company.StudentCourse.dto.BetweenDateDTO;
import com.company.StudentCourse.dto.CourseDTO;
import com.company.StudentCourse.dto.ResultDTO;
import com.company.StudentCourse.dto.StudentCourseMarkDTO;
import com.company.StudentCourse.entity.CourseEntity;
import com.company.StudentCourse.entity.StudentCourseMarkEntity;
import com.company.StudentCourse.entity.StudentEntity;
import com.company.StudentCourse.exp.AppBadRequestException;
import com.company.StudentCourse.exp.StudentNotFoundException;
import com.company.StudentCourse.repository.CourseRepository;
import com.company.StudentCourse.repository.StudentCourseMarkRepository;
import com.company.StudentCourse.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseMarkService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentCourseMarkRepository studentCourseMarkRepository;

    public StudentCourseMarkDTO crate(StudentCourseMarkDTO dto) {
        Optional<StudentEntity> getStudent = studentRepository.findById(dto.getStudentId());
        if (getStudent==null) {
            throw new StudentNotFoundException("Student not found");
        }
        Optional<CourseEntity> getCourse = courseRepository.findById(dto.getCourseId());
        if (getCourse==null) {
            throw new StudentNotFoundException("Course not found");
        }
        StudentCourseMarkEntity entity = new StudentCourseMarkEntity();
        entity.setStudent(getStudent.get());
        entity.setCourse(getCourse.get());
        entity.setMark(dto.getMark());
        entity.setCreatedDate(dto.getCreatedDate());
        studentCourseMarkRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public boolean update(Integer id, StudentCourseMarkDTO dto) {
        StudentCourseMarkEntity entity = get(id);
        Optional<StudentEntity> getStudent = studentRepository.findById(dto.getStudentId());
        if (getStudent==null) {
            throw new StudentNotFoundException("Student not found");
        }
        Optional<CourseEntity> getCourse = courseRepository.findById(dto.getCourseId());
        if (getCourse==null) {
            throw new StudentNotFoundException("Course not found");
        }
        entity.setStudent(getStudent.get());
        entity.setCourse(getCourse.get());
        entity.setMark(dto.getMark());
        entity.setCreatedDate(dto.getCreatedDate());
        return true;
    }

    public StudentCourseMarkEntity get(Integer id) {
        Optional<StudentCourseMarkEntity> optional = studentCourseMarkRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Student not found: " + id);
        }
        return optional.get();
    }
    public StudentCourseMarkDTO getById(Integer id) {
        StudentCourseMarkEntity entity = get(id);
        StudentCourseMarkDTO dto = new StudentCourseMarkDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setMark(entity.getMark());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public ResultDTO getByIdDetail(Integer id) {
        StudentCourseMarkEntity entity = get(id);
        ResultDTO dto = new ResultDTO();
        dto.setId(entity.getId());
        dto.setSId(entity.getStudent().getId());
        dto.setSName(entity.getStudent().getName());
        dto.setSSurname(entity.getStudent().getSurname());
        dto.setCId(entity.getCourse().getId());
        dto.setCName(entity.getCourse().getName());
        dto.setMark(entity.getMark());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public List<StudentCourseMarkDTO> getStudentMarkBetweenDate(Integer id, BetweenDateDTO dto) {
        List<StudentCourseMarkEntity> list = studentCourseMarkRepository.findAllByStudentIdAndCreatedDateBetween(id, dto.getFromDate(), dto.getToDate());
        List<StudentCourseMarkDTO> dtos = new LinkedList<>();
        list.forEach(entity -> {
            StudentCourseMarkDTO scmDto = new StudentCourseMarkDTO();
            StudentCourseMarkDTO toDTO = toDTO(entity, scmDto);
            dtos.add(toDTO);
        });
        return dtos;
    }

    public List<StudentCourseMarkDTO>  getMarkByGivenDate(LocalDate date, Integer id) {
        List<StudentCourseMarkEntity> list = studentCourseMarkRepository.findByCreatedDateAndStudentId(date, id);
        List<StudentCourseMarkDTO> dtoList = new LinkedList<>();
        for (StudentCourseMarkEntity entity : list) {
            StudentCourseMarkDTO dto = new StudentCourseMarkDTO();
            dto.setStudentId(entity.getStudent().getId());
            dto.setCourseId(entity.getCourse().getId());
            dto.setMark(entity.getMark());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentCourseMarkDTO> getMarkByGivenCourse(Integer courseId, Integer studentId) {
        List<StudentCourseMarkEntity> list = studentCourseMarkRepository.findByStudentIdAndCourseIdOrderByCreatedDateDesc(courseId, studentId);

        return null;
    }

    private StudentCourseMarkDTO toDTO(StudentCourseMarkEntity entity, StudentCourseMarkDTO dto) {
        dto.setId(entity.getId());
        dto.setCourseId(entity.getCourse().getId());
        dto.setStudentId(entity.getStudent().getId());
        dto.setMark(entity.getMark());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public List<StudentCourseMarkDTO> getAll() {
        Iterable<StudentCourseMarkEntity> all = studentCourseMarkRepository.findAll();
        List<StudentCourseMarkDTO> dtoList = new LinkedList<>();

        all.forEach(entity -> {
            StudentCourseMarkDTO courseDTO = new StudentCourseMarkDTO();
            courseDTO.setId(entity.getId());
            courseDTO.setStudentId(entity.getStudent().getId());
            courseDTO.setCourseId(entity.getCourse().getId());
            courseDTO.setMark(entity.getMark());
            courseDTO.setCreatedDate(entity.getCreatedDate());
            dtoList.add(courseDTO);
        });
        return dtoList;
    }

    public void test(){
        Object[] courseObj = studentCourseMarkRepository.findLastCourseMarkerAsNative(1);
        if (courseObj!=null && courseObj.length > 0) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId((Integer) courseObj[0]);
            courseDTO.setName((String) courseObj[1]);
        }
        System.out.println("dasda");
    }


}
