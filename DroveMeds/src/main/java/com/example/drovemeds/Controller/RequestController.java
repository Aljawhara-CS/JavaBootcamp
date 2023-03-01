package com.example.drovemeds.Controller;


import com.example.drovemeds.Model.*;
import com.example.drovemeds.Service.HospitalAdminService;
import com.example.drovemeds.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor

public class RequestController {
        private final RequestService requestService;

    @GetMapping("/CentralAdmin/getAll")
    public ResponseEntity getAllRequest(){
        List<Request> requests = requestService.getRequest();
        return ResponseEntity.status(200).body(requests);
    }

    @GetMapping("/HospitalAdmin/get")
        public ResponseEntity getRequestByUser(@AuthenticationPrincipal User user){
            List<Request> requests = requestService.getRequestByUser(user);

            return ResponseEntity.status(200).body(requests);
        }

        @PostMapping("/HospitalAdmin/add/{patientId}")
        public ResponseEntity addRequestByUser(@AuthenticationPrincipal User user,@Valid @RequestBody Request request,  @PathVariable  Integer patientId ){

            requestService.addRequest(request,patientId,user);
            return ResponseEntity.status(200).body("Request Added");
        }

        @PutMapping("/CentralAdmin/update/{id}")
        public ResponseEntity updateRequest(@Valid @RequestBody Request request, @PathVariable Integer id){
            requestService.updateRequest(id, request);
            return ResponseEntity.status(200).body("Request Updated");
        }

        @DeleteMapping("/CentralAdmin/delete/{id}")
        public ResponseEntity deleteRequest(@PathVariable Integer id){

            requestService.deleteRequest(id);
            return ResponseEntity.status(200).body("Request Deleted");}


    @PutMapping("/CentralAdmin/approve/{id}")
    public ResponseEntity Approve(@PathVariable Integer id){
        requestService.ApproveRequest(id);
        return ResponseEntity.status(200).body("Request Approved");
    }

    @PutMapping("/CentralAdmin/delivered/{id}")
    public ResponseEntity delivered(@PathVariable Integer id){
        requestService.deliveredRequest(id);
        return ResponseEntity.status(200).body("Request delivered");
    }

    @GetMapping("/CentralAdmin/level/{level}")
    public ResponseEntity getRequestByLevel(@PathVariable String  level)
    {

        List<Request> requests = requestService.getRequestByLevel(level);
        return ResponseEntity.status(200).body(requests);
    }

    @GetMapping("/CentralAdmin/status/{status}")
    public ResponseEntity getRequestByStatus(@PathVariable String  status)
    {

        List<Request> requests = requestService.getRequestByStatus(status);
        return ResponseEntity.status(200).body(requests);
    }







}
