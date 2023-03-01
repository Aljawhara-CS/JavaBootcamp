package com.example.drovemeds.Repository;

import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Model.Patient;
import com.example.drovemeds.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PatientRepository extends JpaRepository <Patient,Integer> {


    Patient findPatientByPatientId(Integer id);
   List<Patient> findAllByHospital(Hospital hospital);
}
