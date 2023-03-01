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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {


   private final UserRepository userRepository;
   private  final HospitalRepository hospitalRepository;
   private final HospitalAdminRepository hospitalAdminRepository;

   private  final CentralAdminRepository centralAdminRepository;


   public List <User> getAll()

   {
      return userRepository.findAll();
   }


    public void registerUser(HospitalAdminDTO admin)
    {
        Hospital hospital = hospitalRepository.findHospitalById(admin.getHospitalId());

        if (hospital==null)
        {
            throw new ApiException(" hospital  not found!");
        }


        User user =  new User (null,"HospitalAdmin",admin.getEmail(), admin.getPassword(),null,null,null) ;

        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);


        HospitalAdmin hospitalAdmin = new HospitalAdmin(null, admin.getFirst_name(), admin.getLast_name(),"waiting",
                user,hospital) ;

        hospitalAdminRepository.save(hospitalAdmin);
        user.setHospitalAdmin(hospitalAdmin);

        userRepository.save(user);

    }

    public void registerCentralAdmin (CentralAdminDTO admin)
    {


        User user =  new User (null,"CentralAdmin",admin.getEmail(), admin.getPassword(),null,null,null) ;

        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);


        CentralAdmin centralAdmin = new CentralAdmin(null, admin.getFirst_name(), admin.getLast_name(),"Approved", user) ;


        centralAdminRepository.save(centralAdmin);
        user.setCentralAdmin(centralAdmin);


        userRepository.save(user);

    }

  /*  public void registerUser(User user)
    {


        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(hashedPassword);
        user.setType_user("HospitalAdmin");

        userRepository.save(user);
*//*
        HospitalAdmin hospitalAdmin = new HospitalAdmin(null, admin.getFirst_name(), admin.getLast_name(),"waiting",
                user,null) ;

        hospitalAdminRepository.save(hospitalAdmin);

        user.setHospitalAdmin(hospitalAdmin);
        userRepository.save(user);*//*

    }
*/

/*
    public void assignHospitalAdminToHospital(Integer userId, Integer hospitalId)
    {
        Hospital hospitalObj= hospitalRepository.findHospitalById(hospitalId);
        HospitalAdmin hospitalAdmin  = hospitalAdminRepository.findByUserId(userId);

        if (hospitalObj==null|| hospitalAdmin==null)
        {
            throw new ApiException(" User or hospital  not found!");
        }

        hospitalAdmin.setHospital(hospitalObj);
        hospitalAdminRepository.save(hospitalAdmin);

    }
*/


    public void deleteUser(Integer userId)
    {
        User old = userRepository.findUsersByUserId(userId);
        if (old==null)
        {
            throw new ApiException(" User not found");
        }
        userRepository.deleteById(userId);

    }


    public void UpdateUser( Integer userId , HospitalAdminDTO user)
    {
        User updated = userRepository.findUsersByUserId(userId);
        HospitalAdmin hospitalAdmin= hospitalAdminRepository.findByUserId(userId);
        if (updated==null || hospitalAdmin==null)
        {
            throw new ApiException(" User not found");
        }

        hospitalAdmin.setFirst_name(user.getFirst_name());
        hospitalAdmin.setLast_name(user.getLast_name());
        hospitalAdminRepository.save(hospitalAdmin);

        updated.setEmail(user.getEmail());
        updated.setHospitalAdmin(hospitalAdmin);

        userRepository.save(updated);

    }


    public void acceptUser(Integer userId)

    {
        HospitalAdmin found = hospitalAdminRepository.findByUserId(userId);

        if (found==null)
        {
            throw new ApiException(" User not found");
        }

        found.setStatus("Approved");
        hospitalAdminRepository.save(found);

    }


    public void rejectUser(Integer userId)

    {
        HospitalAdmin found = hospitalAdminRepository.findByUserId(userId);

        if (found==null)
        {
            throw new ApiException(" User not found");
        }

        found.setStatus("rejected");
        hospitalAdminRepository.save(found);

    }


}
