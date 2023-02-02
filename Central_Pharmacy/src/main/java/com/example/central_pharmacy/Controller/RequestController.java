package com.example.central_pharmacy.Controller;


import com.example.central_pharmacy.Model.Request;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.central_pharmacy.Service.RequestService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor

public class RequestController {
        private final RequestService requestService;

        @GetMapping("/get")
        public ResponseEntity getRequest(){
            List<Request> requests = requestService.getRequest();
            return ResponseEntity.status(200).body(requests);
        }

        @PostMapping("/add")
        public ResponseEntity addRequest(@Valid @RequestBody Request request){
            requestService.addRequest(request);
            return ResponseEntity.status(200).body("Request Added");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity updateRequest(@Valid @RequestBody Request request, @PathVariable Integer id){
            requestService.updateRequest(id, request);
            return ResponseEntity.status(200).body("Request Updated");
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteRequest(@PathVariable Integer id){

            requestService.deleteRequest(id);
            return ResponseEntity.status(200).body("Request Deleted");}
        
        
    @PutMapping("/price/{id}")
    public ResponseEntity updatePrice(@PathVariable Integer id){
        requestService.totalPrice(id);
        return ResponseEntity.status(200).body("Price Updated ");
    }

    @PutMapping("/check/{id}")
    public ResponseEntity check(@PathVariable Integer id){
        requestService.checkStatus(id);
        return ResponseEntity.status(200).body("Request Approved");
    }



    }
