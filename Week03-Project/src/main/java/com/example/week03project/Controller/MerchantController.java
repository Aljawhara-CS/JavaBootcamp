package com.example.week03project.Controller;

import com.example.week03project.POJO.Merchant;
import com.example.week03project.Service.CategoryService;
import com.example.week03project.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor

public class MerchantController {


        //ArrayList<Merchant> merchants = new ArrayList<>();

    private final MerchantService merchantservice;


    @GetMapping("/getmerchant")
        public ResponseEntity getMerchants()
        {
            ArrayList<Merchant> merchants = merchantservice.getMerchants();
            return  ResponseEntity.status(200).body(merchants);
        }

        @PostMapping("/addmerchant")
        public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchantobj, Errors errors)
        {

            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            merchantservice.addMerchant(merchantobj);
            return ResponseEntity.status(200).body(" Merchant Added!!");

        }

        @PutMapping("/merchant/{index}")
        public ResponseEntity updateMerchant(@Valid @RequestBody Merchant merchantobj,@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            merchantservice.editMerchant(merchantobj,index);
            return ResponseEntity.status(200).body("Merchant updated!!");
        }

        @DeleteMapping ("/merchant/{index}")
        public ResponseEntity deleteMerchant(@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            merchantservice.deleteMerchant(index);
            return ResponseEntity.status(200).body("Merchant Deleted!!");
        }





    }// end




