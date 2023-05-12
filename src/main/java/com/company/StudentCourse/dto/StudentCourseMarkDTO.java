package com.company.StudentCourse.dto;

import com.company.StudentCourse.entity.CourseEntity;
import com.company.StudentCourse.entity.StudentEntity;
import lombok.Data;
import java.time.LocalDate;
@Data
public class StudentCourseMarkDTO {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Integer mark;
    private LocalDate createdDate = LocalDate.now();
}
