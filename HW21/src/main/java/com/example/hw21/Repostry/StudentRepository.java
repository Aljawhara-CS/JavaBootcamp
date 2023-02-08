package com.example.hw21.Repostry;

import com.example.hw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer>{


    Student findStudentById(Integer id);

}
