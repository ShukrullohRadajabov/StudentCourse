package com.company.StudentCourse.repository;

import com.company.StudentCourse.entity.CourseEntity;
import com.company.StudentCourse.enums.StudentGender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    Optional<CourseEntity> findById(Integer integer);
    List<CourseEntity> findByCreatedDate(LocalDate date);
    List<CourseEntity> findByName(String name);
    List<CourseEntity> findByPrice(Double price);
    List<CourseEntity> findByDuration(Integer duration);
    List<CourseEntity> findByCreatedDateBetween(LocalDate date, LocalDate date1);
    List<CourseEntity> findByPriceBetween(Double price, Double price1);

}
