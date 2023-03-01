package com.example.drovemeds.Controller;


import com.example.drovemeds.Model.Medicine;
import com.example.drovemeds.Model.Patient;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Service.*;
import com.example.drovemeds.Service.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping("api/v1/medicine")
public class MedicineController {

    private final MedicineService medicineService;


    @GetMapping("/get")
    public ResponseEntity getAllMedicine()
    {
        List<Medicine> medicine=medicineService.getAllMedicine();
        return ResponseEntity.status(200).body(medicine);

    }


    @GetMapping("/HospitalAdmin/get/{id}")
    public ResponseEntity getMedicineById(@PathVariable Integer id)
    {
        Medicine medicine= medicineService.getMedicineById(id);
        return  ResponseEntity.status(200).body(medicine);

    }

    @PostMapping("/CentralAdmin/add")
    public ResponseEntity addMedicine(@Valid @RequestBody Medicine medicine)
    {

        medicineService.addMedicine(medicine);
        return ResponseEntity.status(200).body("medicine added");

    }

    @PutMapping("/CentralAdmin/update/{id}")
    public ResponseEntity updateMedicine(@PathVariable Integer id, @Valid@RequestBody Medicine medicine)
    {
        medicineService.updateMedicine(id,medicine);
        return ResponseEntity.status(200).body(" Medicine updated!");

    }

    @DeleteMapping("/CentralAdmin/delete/{id}")
    public ResponseEntity deleteMedicine(@PathVariable Integer id){

        medicineService.deleteMedicine(id);
        return ResponseEntity.status(200).body(" Medicine updated!");

    }

    @GetMapping("/CentralAdmin/get/{id}")
    public ResponseEntity getExpireDate(@PathVariable Integer id)
    {

        Medicine medicine=medicineService.getExpireDate(id);
        return ResponseEntity.status(200).body(medicine.getExpire());

    }


}