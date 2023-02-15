package com.example.javabootcamphw28.Controller;


import com.example.javabootcamphw28.Model.Customer;
import com.example.javabootcamphw28.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity getUser(){
        List<Customer> customers = customerService.getUser();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/register")
    public ResponseEntity addUser(@Valid @RequestBody Customer customer)
    {
    /*    customerService.addUser(customer);
        return ResponseEntity.status(200).body("Customer Added");*/

        customerService.register(customer);
        return ResponseEntity.status(200).body("User registered!");

    }
    
    @PostMapping("/login")
    public ResponseEntity login()
    {


        return ResponseEntity.status(200).body("logedin User ");

    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody Customer Customer, @PathVariable Integer id){
        customerService.updateUser(id, Customer);
        return ResponseEntity.status(200).body("Customer Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){

        customerService.deleteUser(id);
        return ResponseEntity.status(200).body("Customer Deleted");}



}
