package com.company.StudentCourse.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResultDTO {
    private Integer id;
    private Integer sId;
    private String sName;
    private String sSurname;
    private Integer cId;
    private String cName;
    private Integer mark;
    private LocalDate createdDate;

}
