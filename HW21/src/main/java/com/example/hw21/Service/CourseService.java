package com.example.hw21.Service;

import com.example.hw21.Exception.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Student;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostry.CourseRepository;
import com.example.hw21.Repostry.StudentRepository;
import com.example.hw21.Repostry.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    private final StudentRepository studentRepository;



    public List<Course> getCourses()
    {
        return  courseRepository.findAll();

    }

    public void addCourse(Course course)
    {
        courseRepository.save(course);

    }
    public void updateCourse(Integer id, Course course)
    {
        Course old=courseRepository.findCourseById(id);
        if (old==null)
        {

            throw new ApiException(" Not found!");
        }
        else

            old.setName(course.getName());
            courseRepository.save(old);

    }

    public void deleteCourse(Integer id)
    {    Course old=courseRepository.findCourseById(id);
        if (old==null)
        {

            throw new ApiException(" Not found!");
        }
        else courseRepository.delete(old);


    }


    public void assignTechWithCou(Integer techid, Integer courid)
    {
        Teacher teacher= teacherRepository.findTeacherById(techid);
        Course course= courseRepository.findCourseById(courid);
        if (course==null|| teacher==null)
        {

            throw new ApiException(" Not found!");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);


    }

    //Create endpoint that take course id and return the teacher name for that class

    public String howIsTeacher (Integer idcourse)
    {

        Course course =courseRepository.findCourseById(idcourse);
        if (course==null)
        {

            throw new ApiException(" Not found!");
        }

        return course.getTeacher().getName();


    }


    public void assignStudentWithCourse(Integer student_id, Integer Course_id)
    {

        Student student= studentRepository.findStudentById(student_id);
        Course course= courseRepository.findCourseById(Course_id);
        if (student==null || course==null)
        {
            throw new ApiException(" Can not Assigned, Objects not found  ");

        }

        student.getCourse().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);


    }

    //Create endpoint that takes class id and return the student list
    public List<Student> getStudentListbyCourseId(Integer courseId)

    {

      Course course= courseRepository.findCourseById(courseId);
      List<Student> student= new ArrayList<>();



        if(course==null)
        {
            throw new ApiException("  not found  ");

        }


        for (int i=0; i<course.getStudents().size();i++) {

            student.add(course.getStudents().get(i));

        }

        return student;




    }

}
