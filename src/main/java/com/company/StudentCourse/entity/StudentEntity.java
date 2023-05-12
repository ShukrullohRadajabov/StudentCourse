package com.company.StudentCourse.entity;

import com.company.StudentCourse.enums.StudentGender;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "level")
    private String level;
    @Column(name = "age")
    private Integer age;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private StudentGender gender;
    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();
}
