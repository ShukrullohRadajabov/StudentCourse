package com.company.StudentCourse.repository;

import com.company.StudentCourse.entity.StudentEntity;
import com.company.StudentCourse.enums.StudentGender;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository  extends CrudRepository<StudentEntity, Integer> {

    Optional<StudentEntity> findById(Integer integer);
    List<StudentEntity> findByCreatedDate(LocalDate date);
    List<StudentEntity> findByName(String name);
    List<StudentEntity> findBySurname(String surname);
    List<StudentEntity> findByAge(Integer age);
    List<StudentEntity> findByGender(StudentGender gender);
    List<StudentEntity> findByLevel(String date);
    List<StudentEntity> findByCreatedDateBetween(LocalDate date, LocalDate date1);
}
