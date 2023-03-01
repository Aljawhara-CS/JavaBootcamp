package com.example.drovemeds.Controller;

import com.example.drovemeds.Model.Hospital;
import com.example.drovemeds.Service.HospitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor

public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/CentralAdmin/get")
    public ResponseEntity getHospitals()
    {
        List<Hospital> hospital = hospitalService.getHospitals();
        return ResponseEntity.status(200).body(hospital);
    }

    @GetMapping("/CentralAdmin/get/{name}")
    public ResponseEntity getHospitalbyName(@Valid @RequestBody String name)
    {
        Hospital hospital = hospitalService.findByName(name);
        return ResponseEntity.status(200).body(hospital);
    }
    @PostMapping("/CentralAdmin/add")
    public ResponseEntity addHospital(@Valid @RequestBody Hospital hospital){
        hospitalService.addHospital(hospital);
        return ResponseEntity.status(200).body("Hospital Added");
    }

    @PutMapping("/CentralAdmin/update/{id}")
    public ResponseEntity updateHospital(@Valid @RequestBody Hospital hospital, @PathVariable Integer id){
        hospitalService.updateHospital(id,hospital);
        return ResponseEntity.status(200).body("Hospital Updated!");
    }


    @DeleteMapping("/CentralAdmin/delete/{id}")
    public ResponseEntity deleteHospital(@PathVariable Integer id){
        hospitalService.deleteHospital(id);
        return ResponseEntity.status(200).body("Hospital Deleted!");
    }



}