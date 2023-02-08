package com.example.hw21.Repostry;

import com.example.hw21.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseById(Integer id);
   // Course findCoursesByStudents

}
