package com.company.StudentCourse.repository;

import com.company.StudentCourse.entity.CourseEntity;
import com.company.StudentCourse.entity.StudentCourseMarkEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentCourseMarkRepository extends CrudRepository<StudentCourseMarkEntity, Integer> {
    List<StudentCourseMarkEntity> findByCreatedDateAndStudentId(LocalDate date, Integer id);

    //  10. Studentni berilgan curse dan olgan baxolari vaqt boyicha kamayish tartibida sord qiling.
    List<StudentCourseMarkEntity> findByStudentIdAndCourseIdOrderByCreatedDateDesc(Integer courseId, Integer studentId);
    List<StudentCourseMarkEntity> findAllByStudentIdAndCreatedDateBetween(Integer id, LocalDate fromDate, LocalDate toDate);

    @Query(value = "SELECT course_id from  student_course_mark where student_id = :studentId order by created_date desc limit 1 ", nativeQuery = true)
    Integer findLastCourseMarker(@Param("studentId") Integer studentId);

    @Query(value = "SELECT c.id, c.name " +
            " from  student_course_mark as scm " +
            " inner join course_t as c on c.id = scm.course_id " +
            " where scm.student_id = :studentId  " +
            "order by scm.created_date desc limit 1 ", nativeQuery = true)
    Object[] findLastCourseMarkerAsNative(@Param("studentId") Integer studentId);


}
