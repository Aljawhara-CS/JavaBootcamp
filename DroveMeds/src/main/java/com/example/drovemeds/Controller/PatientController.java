package com.example.drovemeds.Controller;


import com.example.drovemeds.Model.Patient;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor

public class PatientController {


    private final PatientService patientService;

    @GetMapping("/HospitalAdmin/get")
    public ResponseEntity getPatients(@AuthenticationPrincipal User user)
    {
        List<Patient> patients= patientService.getPatientsHospital(user);
        return  ResponseEntity.status(200).body(patients);

    }

    @GetMapping("/HospitalAdmin/get/{id}")
    public ResponseEntity getPatientById(@PathVariable Integer id, @AuthenticationPrincipal User user)
    {
        Patient patient= patientService.getPatient(id,user);
        return  ResponseEntity.status(200).body(patient);

    }

    @PostMapping("/HospitalAdmin/add")
    public ResponseEntity addPatient(@Valid @RequestBody Patient patient,@AuthenticationPrincipal User user)

    {

        patientService.addPatient(patient,user);
        return ResponseEntity.status(200).body(" Patient  Added!");

    }

    @PutMapping("/HospitalAdmin/update/{id}")
    public  ResponseEntity updatePatient(@PathVariable Integer id, @Valid@RequestBody  Patient patient,@AuthenticationPrincipal User user)

    {

        patientService.updatePatient(patient,id,user);
        return ResponseEntity.status(200).body(" Patient updated!");

    }

    @DeleteMapping ("/HospitalAdmin/delete/{id}")
    public  ResponseEntity deletePatient(@PathVariable Integer id,@AuthenticationPrincipal User user)

    {

        patientService.deletePatient(id,user);
        return ResponseEntity.status(200).body(" Patient deleted!");

    }



}
