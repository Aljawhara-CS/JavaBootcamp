package com.example.hw21.Service;


import com.example.hw21.Exception.ApiException;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Student;
import com.example.hw21.Repostry.AddressRepository;
import com.example.hw21.Repostry.CourseRepository;
import com.example.hw21.Repostry.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class StudentService {


    public final StudentRepository studentRepository;




    public List<Student> getStudents()
    {

        return studentRepository.findAll();
    }

    public  void  addStudent(Student Student)

    {
        studentRepository.save(Student);

    }

    public  void  UpdateStudent(Student Student, Integer id)
    {

        Student old= studentRepository.findStudentById(id);

        if(old==null) {
            throw new ApiException(" Student not found");

        }

        old.setName(Student.getName());
        old.setAge(Student.getAge());
        old.setMajor(Student.getMajor());
        studentRepository.save(old);

    }


    public  void  DeleteStudent (Integer id)
    {
        Student found= studentRepository.findStudentById(id);
        if(found!=null)
        {
            studentRepository.deleteById(id);
        }

        else throw new ApiException(" Student not found");

    }



   // Create endpoint that takes student id and major and change the student major
    // ( changing the major will drop all the cousres that the student attended to )


    public void ChangeStudentMajor( Integer student_id, String newMajor)
    {
        Student student= studentRepository.findStudentById(student_id);

        if(student!=null)
        {

            for (int i=0; i<student.getCourse().size();i++)
            {

                student.getCourse().remove(i);

            }
            student.setMajor(newMajor);
            studentRepository.save(student);
        }

        else throw new ApiException(" Student not found");


    }













}
