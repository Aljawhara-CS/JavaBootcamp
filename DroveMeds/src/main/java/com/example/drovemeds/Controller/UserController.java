package com.example.drovemeds.Controller;

import com.example.drovemeds.DTO.CentralAdminDTO;
import com.example.drovemeds.DTO.HospitalAdminDTO;
import com.example.drovemeds.Model.HospitalAdmin;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Repository.UserRepository;
import com.example.drovemeds.Service.CentralAdminService;
import com.example.drovemeds.Service.HospitalAdminService;
import com.example.drovemeds.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {


        private final UserService userService;
       private  final CentralAdminService centralAdminService;
        private  final HospitalAdminService hospitalAdminService;

        @PostMapping("/login")
        public ResponseEntity login(){

            return ResponseEntity.status(200).body( "Welcome back");
        }

        @GetMapping("/CentralAdmin/get")
        public ResponseEntity getAllUser()
        {
            List<User> user = userService.getAll();
            return ResponseEntity.status(200).body(user);
        }


        @PostMapping("/register")
        public ResponseEntity registerUser(@Valid @RequestBody HospitalAdminDTO user){
            userService.registerUser(user);
            return ResponseEntity.status(200).body("User register");
        }
       @PostMapping("/registerCentralAdmin")
        public ResponseEntity registerCentralAdmin(@Valid @RequestBody CentralAdminDTO dto){
           userService.registerCentralAdmin(dto);
        return ResponseEntity.status(200).body("Central Admin register");
    }


/*         @PostMapping("/registerHospitalAdmin/{hospitalId}")
        public ResponseEntity registerCentralAdmin(@Valid @RequestBody HospitalAdminDTO dto,@PathVariable Integer hospitalId){
             hospitalAdminService.addHospitalAdmin(dto,hospitalId);
        return ResponseEntity.status(200).body("Hospital Admin register");
    }*/

/*        @PutMapping("/HospitalAdmin/{hospitalId}/{userid}")
        public ResponseEntity assignHospitalAdminToHospital(@PathVariable Integer userid,@PathVariable Integer hospitalId){
            hospitalAdminService.assignHospitalAdminToHospital(userid,hospitalId);
            return ResponseEntity.status(200).body("assign Hospital Admin To Hospital Done!");
        }*/


        @PutMapping("/CentralAdmin/update/{id}")
        public ResponseEntity updateUser(@Valid @RequestBody HospitalAdminDTO User, @PathVariable Integer id){
            userService.UpdateUser(id,User);
            return ResponseEntity.status(200).body("User Updated!");
        }


        @DeleteMapping("/CentralAdmin/delete/{id}")
        public ResponseEntity deleteUser(@PathVariable Integer id){
            userService.deleteUser(id);
            return ResponseEntity.status(200).body("User Deleted!");
        }

      @PutMapping("/CentralAdmin/accept/{id}")
      public ResponseEntity acceptUser( @PathVariable Integer id){
        userService.acceptUser(id);
        return ResponseEntity.status(200).body("User accept!");
    }

    @PutMapping("/CentralAdmin/reject/{id}")
    public ResponseEntity rejectUser( @PathVariable Integer id){
        userService.rejectUser(id);
        return ResponseEntity.status(200).body("User reject!");
    }



    }
