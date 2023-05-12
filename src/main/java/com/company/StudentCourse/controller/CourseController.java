package com.company.StudentCourse.cotroller;

import com.company.StudentCourse.dto.CourseDTO;
import com.company.StudentCourse.dto.StudentDTO;
import com.company.StudentCourse.enums.StudentGender;
import com.company.StudentCourse.service.CourseService;
import com.company.StudentCourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        CourseDTO dto = courseService.getById(id);
        return ResponseEntity.ok(dto);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody CourseDTO dto) {
        CourseDTO response = courseService.crate(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> list = courseService.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody CourseDTO dto) {
        return ResponseEntity.ok(courseService.update(id, dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(courseService.delete(id));
    }

    @GetMapping(value = "/get_by_given_date/{date}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("date") LocalDate date) {
        List<CourseDTO> list = courseService.getByGivenDate(date);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_name/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name) {
        List<CourseDTO> list = courseService.getByName(name);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_price/{price}")
    public ResponseEntity<?> getByPrice(@PathVariable("price") Double price) {
        List<CourseDTO> list = courseService.getByPrice(price);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_duration/{duration}")
    public ResponseEntity<?> getByLevel(@PathVariable("duration") Integer duration) {
        List<CourseDTO> list = courseService.getByDuration(duration);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/get_by_between_dates/{date}/{date1}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("date") LocalDate date, @PathVariable("date1") LocalDate date1) {
        List<CourseDTO> list = courseService.getBetweenDates(date, date1);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_between_price/{price}/{price1}")
    public ResponseEntity<?> getByBetweenPrice(@PathVariable("price") Double price,
                                               @PathVariable("price1") Double price1) {
        List<CourseDTO> list = courseService.getBetweenPrice(price, price1);
        return ResponseEntity.ok(list);
    }

}

