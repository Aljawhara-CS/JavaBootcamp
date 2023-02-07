package com.example.hw21.Service;

import com.example.hw21.Exception.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostry.CourseRepository;
import com.example.hw21.Repostry.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;



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


}
