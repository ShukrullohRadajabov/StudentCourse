package com.company.StudentCourse.service;

import com.company.StudentCourse.dto.CourseDTO;
import com.company.StudentCourse.entity.CourseEntity;
import com.company.StudentCourse.exp.AppBadRequestException;
import com.company.StudentCourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO getById(Integer id) {
        CourseEntity entity = get(id);
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public CourseEntity get(Integer id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestException("Student not found: " + id);
        }
        return optional.get();
    }

    public CourseDTO crate(CourseDTO dto) {
        CourseEntity entity = new CourseEntity();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setDuration(dto.getDuration());
        entity.setCreatedDate(dto.getCreatedDate());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getPrice() == null) {
            throw new AppBadRequestException("Price qani?");
        }
        if (dto.getDuration() == null) {
            throw new AppBadRequestException("Duration qani?");
        }
        courseRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public List<CourseDTO> getAll() {
        Iterable<CourseEntity> all = courseRepository.findAll();
        List<CourseDTO> dtoList = new LinkedList<>();

        all.forEach(courseEntity -> {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(courseEntity.getId());
            courseDTO.setName(courseEntity.getName());
            courseDTO.setPrice(courseEntity.getPrice());
            courseDTO.setDuration(courseEntity.getDuration());
            courseDTO.setCreatedDate(courseEntity.getCreatedDate());
            dtoList.add(courseDTO);
        });
        return dtoList;
    }

    public boolean update(Integer id, CourseDTO studentDTO) {
        CourseEntity entity = get(id);
        entity.setName(studentDTO.getName());
        entity.setPrice(studentDTO.getPrice());
        entity.setDuration(studentDTO.getDuration());
        entity.setCreatedDate(studentDTO.getCreatedDate());
        return true;
    }

    public boolean delete(Integer id) {
        CourseEntity entity = get(id);
        courseRepository.delete(entity);
        return true;
    }


    public List<CourseDTO> getByGivenDate(LocalDate date) {
        List<CourseEntity> list = courseRepository.findByCreatedDate(date);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }


    public List<CourseDTO> getByName(String field) {
        List<CourseEntity> list = courseRepository.findByName(field);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }


    public List<CourseDTO> getByPrice(Double field) {
        List<CourseEntity> list = courseRepository.findByPrice(field);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<CourseDTO> getByDuration(Integer field) {
        List<CourseEntity> list = courseRepository.findByDuration(field);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<CourseDTO> getBetweenDates(LocalDate date, LocalDate date1) {
        List<CourseEntity> list = courseRepository.findByCreatedDateBetween(date, date1);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<CourseDTO> getBetweenPrice(Double course, Double course1) {
        List<CourseEntity> list = courseRepository.findByPriceBetween(course, course1);
        List<CourseDTO> dtoList = new LinkedList<>();
        for (CourseEntity entity : list) {
            CourseDTO dto = new CourseDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPrice(entity.getPrice());
            dto.setDuration(entity.getDuration());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
