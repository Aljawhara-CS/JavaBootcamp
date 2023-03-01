package com.example.drovemeds.Service;


import com.example.drovemeds.DTO.CentralAdminDTO;
import com.example.drovemeds.DTO.HospitalAdminDTO;
import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.CentralAdmin;
import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Model.HospitalAdmin;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Repository.CentralAdminRepository;
import com.example.drovemeds.Repository.HospitalAdminRepository;
import com.example.drovemeds.Repository.HospitalRepository;
import com.example.drovemeds.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CentralAdminService {



    private final UserRepository userRepository;
    private  final HospitalRepository hospitalRepository;
    private final CentralAdminRepository centralAdminRepository;


    public List<CentralAdmin> getAll()


    {
        return centralAdminRepository.findAll();
    }


    public void addCentralAdmin(CentralAdminDTO admin)
    {

        User user = userRepository.findUsersByUserId(admin.getUserId());

        if (user==null)
        {
            throw new ApiException(" User not found!");
        }

        CentralAdmin centralAdmin = new CentralAdmin(null, admin.getFirst_name(), admin.getLast_name(),"Approved",user);

        centralAdminRepository.save(centralAdmin);

        user.setCentralAdmin(centralAdmin);
        userRepository.save(user);

    }




}
