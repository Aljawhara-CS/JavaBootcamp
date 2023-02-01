package com.example.central_pharmacy.Service;

import com.example.central_pharmacy.Exception.ApiException;
import com.example.central_pharmacy.Model.Patient;
import com.example.central_pharmacy.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PatientService {

    public final PatientRepository patientRepository;


    public List<Patient> getPatients()
    {

        return patientRepository.findAll();
    }

    public void addPatient( Patient patient)
    {

        patientRepository.save(patient);
    }


    public void updatePatient( Patient patient, Integer id) {
        Patient old = patientRepository.findByInsuranceId(id);

        if (old == null)
        {
            throw new ApiException(" Patient  not found");
        }


        old.setInsuranceId(patient.getInsuranceId());
        old.setHospitalId(patient.getHospitalId());

        old.setName(patient.getName());
        old.setAge(patient.getAge());
        old.setCity(patient.getCity());
        old.setNationalAddress(patient.getNationalAddress());
        old.setEmail(patient.getEmail());
        old.setBalance(patient.getBalance());
        old.setStartDate(patient.getStartDate());
        old.setLastDate(patient.getLastDate());


        patientRepository.save(old);

    }

    public void deletePatient( Integer id)

    {

        Patient old = patientRepository.findByInsuranceId(id);
        if(old!=null)
        {
         patientRepository.deleteById(id);
        }
         else throw new ApiException(" Patient  not found");



    }




    }
