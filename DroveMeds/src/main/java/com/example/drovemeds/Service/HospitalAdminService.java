package com.example.drovemeds.Service;


import com.example.drovemeds.DTO.HospitalAdminDTO;
import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Model.HospitalAdmin;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Repository.HospitalAdminRepository;
import com.example.drovemeds.Repository.HospitalRepository;
import com.example.drovemeds.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalAdminService {



    private final UserRepository userRepository;
    private  final HospitalRepository hospitalRepository;
    private final HospitalAdminRepository hospitalAdminRepository;

  /*  public List<HospitalAdmin> getequestByHospitalAdminId(Integer userid)
    {
        return hospitalAdminRepository.findAllByHospitalAdmin(userid);
    }*/
    public List<HospitalAdmin> getAll()

    {
        return hospitalAdminRepository.findAll();
    }

    public void addHospitalAdmin(HospitalAdminDTO admin, Integer hospitalId)
    {
        Hospital hospital = hospitalRepository.findHospitalById(hospitalId);

        if (hospital==null)
        {
            throw new ApiException(" hospital  not found!");
        }





        HospitalAdmin hospitalAdmin = new HospitalAdmin(null, admin.getFirst_name(), admin.getLast_name(),"waiting",
                null,hospital) ;
        hospitalAdminRepository.save(hospitalAdmin);

        User user =  new User (null,"HospitalAdmin",admin.getEmail(), admin.getPassword(),null,hospitalAdmin,null) ;

        String hashedPassword= new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setHospitalAdmin(hospitalAdmin);

        userRepository.save(user);

    }


    public void assignHospitalAdminToHospital(Integer adminId, Integer hospitalId)
    {
        Hospital hospitalObj= hospitalRepository.findHospitalById(hospitalId);
        HospitalAdmin hospitalAdmin  = hospitalAdminRepository.findByUserId(adminId);

        if (hospitalObj==null|| hospitalAdmin==null)
        {
            throw new ApiException(" User or hospital  not found!");
        }

        hospitalAdmin.setHospital(hospitalObj);
        hospitalAdminRepository.save(hospitalAdmin);

    }

}
