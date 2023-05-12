package com.company.StudentCourse.dto;
import com.company.StudentCourse.enums.StudentGender;
import lombok.Data;

import java.time.LocalDate;
@Data

public class StudentDTO {
    private Integer id;
    private String name;
    private String surname;
    private String level;
    private Integer age;
    private StudentGender gender;
    private LocalDate createdDate = LocalDate.now();

}
