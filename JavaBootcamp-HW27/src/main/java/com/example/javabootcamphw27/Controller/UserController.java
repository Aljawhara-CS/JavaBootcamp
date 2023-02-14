package com.example.javabootcamphw27.Controller;


import com.example.javabootcamphw27.Model.User;
import com.example.javabootcamphw27.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {


    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User myUser){
        authService.register(myUser);
        return ResponseEntity.status(200).body("User registered ");
    }



    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Welcome back");
    }
}
