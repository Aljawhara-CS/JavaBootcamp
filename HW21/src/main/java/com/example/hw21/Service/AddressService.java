package com.example.hw21.Service;

import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Exception.ApiException;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repostry.AddressRepository;
import com.example.hw21.Repostry.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class AddressService {


    private  final TeacherRepository teacherRepository;
    private  final AddressRepository addressRepository;


    public  void addTeacherAddress(AddressDTO cd)
    {
        Teacher teacher=teacherRepository.findTeacherById(cd.getTeacher_id());
        if(teacher==null)
        {
            throw  new ApiException("Teacher not found");
        }

        Address address= new Address(null, cd.getArea(), cd.getStreet(), cd.getBuildingNumber(),teacher);
        addressRepository.save(address);

    }


    public void updateTeacherAddress(AddressDTO cd)
    {

        Address address=addressRepository.findAddressById(cd.getTeacher_id());
        if(address==null)
        {
            throw  new ApiException("Teacher's address not found");
        }

        address.setArea(cd.getArea());
        address.setStreet(cd.getStreet());
        address.setBuildingNumber(cd.getBuildingNumber());


        addressRepository.save(address);

    }

    public void deleteTeacherAddress(Integer id)
    {

        Address address=addressRepository.findAddressById(id);
        if(address==null)
        {
            throw  new ApiException("Teacher's address not found");
        }


        addressRepository.delete(address);

    }




}
