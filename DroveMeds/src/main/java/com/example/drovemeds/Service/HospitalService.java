package com.example.drovemeds.Service;

import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public List<Hospital> getHospitals() {
        return hospitalRepository.findAll();
    }

    public void addHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
    }


    public void updateHospital(Integer id, Hospital hospital) {

        Hospital old = hospitalRepository.findHospitalById(id);

        if (old == null) {
            throw new ApiException(" hospital  not found");
        }

        old.setName(hospital.getName());
        old.setShortCode(hospital.getShortCode());
        old.setCity(hospital.getCity());
        old.setCountry(hospital.getCountry());

        hospitalRepository.save(old);
    }

    public void deleteHospital(Integer id)
    {

        Hospital old = hospitalRepository.findHospitalById(id);

        if (old == null) {
            throw new ApiException(" hospital  not found");

        }

        hospitalRepository.deleteById(id);

    }


    public Hospital findByName( String name)
    {
        Hospital hospital = hospitalRepository.findHospitalByName(name);

        if (hospital == null) {
            throw new ApiException(" hospital  not found");
        }
        return hospital;


    }

}
