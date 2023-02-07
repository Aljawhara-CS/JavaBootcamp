package com.example.hw21.Controller;

import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.AddressService;
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


    @GetMapping("/get")
    public ResponseEntity getTeacher()
    {
        List<Teacher> teachers= teacherService.getTeachers();
        return  ResponseEntity.status(200).body(teachers);

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

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacherAddress(@Valid @RequestBody Teacher teacher,@PathVariable Integer id)

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

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer id)
    {
        Address address= teacherService.getTeacherDetails(id);
        return  ResponseEntity.status(200).body(address);

    }





}
