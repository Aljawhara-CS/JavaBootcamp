package com.example.hw21.Controller;

import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Student;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.AddressService;
import com.example.hw21.Service.CourseService;
import com.example.hw21.Service.StudentService;
import com.example.hw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {

    private final TeacherService teacherService;
    private final AddressService addressService;
    private  final CourseService courseService;
    private  final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getTeacher()
    {
        List<Teacher> teachers= teacherService.getTeachers();
        return  ResponseEntity.status(200).body(teachers);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id)
    {
        Teacher teacher=teacherService.getTeacherDetails(id);
        return  ResponseEntity.status(200).body(teacher);

    }

    @PostMapping("/get/course")
    public ResponseEntity getCourse()

    {
        List<Course> course = courseService.getCourses();
        return ResponseEntity.status(200).body(course);
    }

    @PostMapping("/get/student")
    public ResponseEntity getStudent()

    {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher)

    {


        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(" Teacher Added!");

    }
    @PostMapping("/add/address")
    public ResponseEntity addTeacherAddress(@Valid @RequestBody AddressDTO cd)

    {


        addressService.addTeacherAddress(cd);
        return ResponseEntity.status(200).body(" Teacher Address Added!");

    }

    @PostMapping("/add/course")
    public ResponseEntity addCourse(@Valid @RequestBody Course course)

    {


        courseService.addCourse(course);
        return ResponseEntity.status(200).body(" course Added!");

    }

    @PostMapping("/add/student")
    public ResponseEntity addStudent(@Valid @RequestBody Student student)

    {

       studentService.addStudent(student);
        return ResponseEntity.status(200).body(" Student Added!");

    }


    @PostMapping("/add/student/{studentid}/{idcour}")
    public ResponseEntity assignStudentWithCourse(@PathVariable Integer studentid, @PathVariable Integer idcour)
    {

       courseService.assignStudentWithCourse(studentid,idcour);
        return ResponseEntity.status(200).body(" Done, Course Linked with Student in both way!");



    }

    @PostMapping("/add/course/{idtech}/{idcour}")
    public ResponseEntity assignTechWithCou(@PathVariable Integer idcour, @PathVariable Integer idtech)
    {

        courseService.assignTechWithCou(idtech,idcour);
        return ResponseEntity.status(200).body(" Done, Course Linked with Teacher!");



    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher,@PathVariable Integer id)

    {

    teacherService.UpdateTeacher(teacher,id);
    return ResponseEntity.status(200).body(" Teacher Updated!");

    }

    @PutMapping("/update/address")
    public ResponseEntity updateTeacherAddress(@Valid @RequestBody AddressDTO cd)

    {

      addressService.updateTeacherAddress(cd);
        return ResponseEntity.status(200).body(" Teacher Address Updated!");

    }
    @PutMapping("/update/course/{id}")
    public ResponseEntity updateCourse( @PathVariable Integer id,@Valid @RequestBody Course course)

    {
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body(" Course Updated!");

    }

    @PutMapping("/update/student/{id}")
    public ResponseEntity updateStudent( @PathVariable Integer id,@Valid @RequestBody Student student)

    {

        studentService.UpdateStudent(student,id);
        return ResponseEntity.status(200).body(" Student Updated!");

    }


    @DeleteMapping("/delete/address/{id}")
    public ResponseEntity DeleteTeacherAddress(@PathVariable Integer id)

    {

        addressService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body(" Teacher Address Deleted!");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteTeacher(@PathVariable Integer id)

    {

        teacherService.DeleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher Deleted!");

    }

    @DeleteMapping("/delete/course/{id}")
    public ResponseEntity DeleteCourse(@PathVariable Integer id)

    {

        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course Deleted!");

    }

    @DeleteMapping("/delete/student/{id}")
    public ResponseEntity DeleteStudent(@PathVariable Integer id)

    {

        studentService.DeleteStudent(id);
        return ResponseEntity.status(200).body("student Deleted!");

    }


    @GetMapping("/get/course/{id}")
    public ResponseEntity getTeacherName(@PathVariable Integer id)
    {

        String name=  courseService.howIsTeacher(id);
        return ResponseEntity.status(200).body(name);


    }

    @PutMapping("/update/student/{newmajor}/{id}")
    public ResponseEntity ChangeStudentMajor(@PathVariable Integer id, @PathVariable String newmajor)

    {

        studentService.ChangeStudentMajor(id,newmajor);
        return ResponseEntity.status(200).body("Done!");


    }


    @GetMapping("/get/student/{id}")

    public ResponseEntity getStudentListbyCourseId(@PathVariable Integer id)
    {

        List<Student> students = courseService.getStudentListbyCourseId(id);
        return ResponseEntity.status(200).body(students);


    }





}
