package com.example.drovemeds.Controller;


import com.example.drovemeds.DTO.DetailDTO;
import com.example.drovemeds.Model.Request;
import com.example.drovemeds.Model.requestDetails;
import com.example.drovemeds.Service.RequestDetailsService;
import com.example.drovemeds.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/detail")
@RequiredArgsConstructor

public class RequestDetailsController {
        private final RequestDetailsService requestDetailsService;

        @GetMapping("/CentralAdmin/get")
        public ResponseEntity getRequest(){


            List<requestDetails> details = requestDetailsService.getRequestDetailsService();
            return ResponseEntity.status(200).body(details);
        }

        @PostMapping("/HospitalAdmin/add/{requestId}")
        public ResponseEntity addRequestDetails(@Valid @RequestBody DetailDTO obj, @PathVariable  Integer requestId ){

            requestDetailsService.AddMedicineItemToRequest(obj,requestId);
            return ResponseEntity.status(200).body("Request Details Added");
        }
    @PutMapping ("/HospitalAdmin/update/{requestId}")
    public ResponseEntity editRequestDetails(@Valid @RequestBody requestDetails obj, @PathVariable  Integer requestId ){

        requestDetailsService.editMedicineItemToRequest(requestId,obj);
        return ResponseEntity.status(200).body("Request Details updated");
    }

    @DeleteMapping ("/HospitalAdmin/delete/{requestId}")
    public ResponseEntity DeleteRequestDetails(@PathVariable  Integer requestId ){

        requestDetailsService.DeleteMedicineItemInRequest(requestId);
        return ResponseEntity.status(200).body("Request Details Deleted");
    }



}
