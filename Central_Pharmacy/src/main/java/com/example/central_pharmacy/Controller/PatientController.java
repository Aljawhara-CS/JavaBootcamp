package com.example.central_pharmacy.Controller;


import com.example.central_pharmacy.Model.Patient;
import com.example.central_pharmacy.Service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor

public class PatientController {


    private final PatientService patientService;

    @GetMapping("/get")
    public ResponseEntity getPatients()
    {
        List<Patient> patients= patientService.getPatients();
        return  ResponseEntity.status(200).body(patients);

    }

    @PostMapping("/add")
    public ResponseEntity addPatient(@Valid @RequestBody Patient patient)

    {

        patientService.addPatient(patient);
        return ResponseEntity.status(200).body(" Patient Company Added!");

    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updatePatient(@PathVariable Integer id, @Valid@RequestBody  Patient patient)

    {

        patientService.updatePatient(patient,id);
        return ResponseEntity.status(200).body(" Patient updated!");

    }

    @DeleteMapping ("/delete/{id}")
    public  ResponseEntity deletePatient(@PathVariable Integer id)

    {

        patientService.deletePatient(id);
        return ResponseEntity.status(200).body(" Patient deleted!");

    }




}
