package com.example.hw21.Service;


import com.example.hw21.Exception.ApiException;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostry.AddressRepository;
import com.example.hw21.Repostry.CourseRepository;
import com.example.hw21.Repostry.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TeacherService {


    public final TeacherRepository teacherRepository;
    public final AddressRepository addressRepository;
    public final CourseRepository courseRepository;



    public List<Teacher> getTeachers()
    {

        return teacherRepository.findAll();
    }

    public  void  addTeacher(Teacher teacher)

    {
        teacherRepository.save(teacher);

    }

    public  void  UpdateTeacher(Teacher teacher, Integer id)
    {

        Teacher old= teacherRepository.findTeacherById(id);

        if(old==null) {
            throw new ApiException(" Teacher not found");

        }

        old.setName(teacher.getName());
        teacherRepository.save(old);

    }


    public  void  DeleteTeacher (Integer id)
    {
        Teacher found= teacherRepository.findTeacherById(id);
        if(found!=null)
        {
            teacherRepository.deleteById(id);
        }

        else throw new ApiException(" Teacher not found");

    }

   // Create endpoint that takes teacher id and return All teacher details

    public  Teacher  getTeacherDetails (Integer id)
    {
        Teacher teacher= teacherRepository.findTeacherById(id);
        Address address= addressRepository.findAddressById(id);

        if(teacher==null || address==null)
        {
                     throw new ApiException(" id not found");
        }

        teacher.setAddress(address);
        return  teacher;


    }

    //Create endpoint that takes teacher id and return All teacher details



    public  Teacher getTeacherInfo( Integer id)
    {

        Teacher teacher= teacherRepository.findTeacherById(id);

        if(teacher==null)
        {
            throw new ApiException(" id not found");
        }

        return teacher;

    }












}
