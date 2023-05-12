package com.company.StudentCourse.dto;
import lombok.Data;

import java.time.LocalDate;

@Data

public class CourseDTO {
    private Integer id;
    private String name;
    private Double price;
    private Integer duration;
    private LocalDate createdDate = LocalDate.now();
}
