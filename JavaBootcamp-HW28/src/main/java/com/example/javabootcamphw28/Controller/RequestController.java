package com.example.javabootcamphw28.Controller;


import com.example.javabootcamphw28.Model.Customer;
import com.example.javabootcamphw28.Model.Product;
import com.example.javabootcamphw28.Model.Request;
import com.example.javabootcamphw28.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor

public class RequestController {
        private final RequestService requestService;

        @GetMapping("/get")
        public ResponseEntity getRequest(){
            List<Request> requests = requestService.getOrder();
            return ResponseEntity.status(200).body(requests);
        }

        @PostMapping("/add")
        public ResponseEntity addRequest(@Valid @RequestBody Request request, Customer customer, Product product){
            requestService.addOrder(request, customer,product);
            return ResponseEntity.status(200).body("Request Added");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateRequest(@Valid @RequestBody Request request, @PathVariable Integer id){
            requestService.updateOrder(id, request);
            return ResponseEntity.status(200).body("Request Updated");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteRequest(@PathVariable Integer id){

            requestService.deleteOrder(id);
            return ResponseEntity.status(200).body("Request Deleted");}


  /*  @PutMapping("/price/{id}")
    public ResponseEntity updatePrice(@PathVariable Integer id){
        requestService.totalPrice(id);
        return ResponseEntity.status(200).body("Price Updated ");
    }*/

    @PutMapping("/status/{id}")
    public ResponseEntity changeStatus(@PathVariable Integer id, Customer customer){
        requestService.changeStatus(id, customer);
        return ResponseEntity.status(200).body("Request updated");
    }

/*
    @GetMapping("/level/{level}")
    public ResponseEntity getRequestByLevel(@PathVariable String  level)
    {


        List<Request> requests = requestService.getRequestByLevel(level);
        return ResponseEntity.status(200).body(requests);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity getRequestByStatus(@PathVariable String  status)
    {


        List<Request> requests = requestService.getRequestByStatus(status);
        return ResponseEntity.status(200).body(requests);
    }*/




}
