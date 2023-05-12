package com.company.StudentCourse.cotroller;

import com.company.StudentCourse.dto.BetweenDateDTO;
import com.company.StudentCourse.dto.ResultDTO;
import com.company.StudentCourse.dto.StudentCourseMarkDTO;
import com.company.StudentCourse.dto.StudentDTO;
import com.company.StudentCourse.enums.StudentGender;
import com.company.StudentCourse.service.StudentCourseMarkService;
import com.company.StudentCourse.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/student-course-mark")
public class StudentCourseMarkController {
    @Autowired
    private StudentCourseMarkService service;


    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentCourseMarkDTO dto) {
        StudentCourseMarkDTO response = service.crate(dto);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentCourseMarkDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        StudentCourseMarkDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/get-detail/{id}")
    public ResponseEntity<?> getByIdDetail(@PathVariable("id") Integer id) {
        ResultDTO dto = service.getByIdDetail(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<StudentCourseMarkDTO>> getAll() {
        List<StudentCourseMarkDTO> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/get_by_given_date/{date}/{id}")
    public ResponseEntity<?> getByGivenDate(@PathVariable("date") LocalDate date,
                                            @PathVariable("id") Integer id) {
            List<StudentCourseMarkDTO> dto = service.getMarkByGivenDate(date, id);
        return ResponseEntity.ok(dto);
    }
    //  10. Studentni berilgan curse dan olgan baxolari vaqt boyicha kamayish tartibida sord qiling.
    @GetMapping(value = "/get-mark-desc-time/{courseId}/{studentId}")
    public ResponseEntity<?> getMarkByCourse(@PathVariable("courseId") Integer courseId,
                                             @PathVariable("studentId") Integer studentId){
        List<StudentCourseMarkDTO> dto = service.getMarkByGivenCourse(courseId, studentId);
        return ResponseEntity.ok(dto);
    }


    @GetMapping(value = "/get-student-mark-between-date/{id}")
    public ResponseEntity<List<StudentCourseMarkDTO>> getStudentMarkBetweenDate(@PathVariable("id") Integer id, @RequestBody BetweenDateDTO dto){
        List<StudentCourseMarkDTO> list = service.getStudentMarkBetweenDate(id, dto);
        return ResponseEntity.ok(list);
    }

    //==================================================================================



/*





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
*/

}

