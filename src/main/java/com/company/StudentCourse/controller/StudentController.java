package com.company.StudentCourse.cotroller;

import com.company.StudentCourse.dto.StudentDTO;
import com.company.StudentCourse.enums.StudentGender;
import com.company.StudentCourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        StudentDTO dto = studentService.getById(id);
        return ResponseEntity.ok(dto);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO) {
        StudentDTO response = studentService.crate(studentDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentDTO>> getAll() {
        List<StudentDTO> list = studentService.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

    @GetMapping(value = "/get_by_given_date/{date}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("date") LocalDate date) {
        List<StudentDTO> list = studentService.getByGivenDate(date);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_between_dates/{date}/{date1}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("date") LocalDate date, @PathVariable("date1") LocalDate date1) {
        List<StudentDTO> list = studentService.getBetweenDates(date, date1);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        List<StudentDTO> list = studentService.getByName(name);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_surname/{surname}")
    public ResponseEntity<?> getBySurname(@PathVariable("surname") String surname) {
        List<StudentDTO> list = studentService.getBySurname(surname);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_level/{level}")
    public ResponseEntity<?> getByLevel(@PathVariable("level") String level) {
        List<StudentDTO> list = studentService.getByLevel(level);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_age/{age}")
    public ResponseEntity<?> getByAge(@PathVariable("age") Integer age) {
        List<StudentDTO> list = studentService.getByAge(age);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_gender/{gender}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("gender") StudentGender gender) {
        List<StudentDTO> list = studentService.getByGender(gender);
        return ResponseEntity.ok(list);
    }

}

