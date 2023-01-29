package com.example.week03project.Controller;

import com.example.week03project.POJO.User;
import com.example.week03project.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor

public class UserController {



       // ArrayList<User> user= new ArrayList<>();
        private final UserService userService;

        @GetMapping("/getuser")
        public ResponseEntity getUser()
        {
            ArrayList<User> user = userService.getUsers();
            return  ResponseEntity.status(200).body(user);
        }

        @PostMapping("/adduser")
        public ResponseEntity addUser(@Valid @RequestBody User userobj, Errors errors)
        {

            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            userService.addUser(userobj);
            return ResponseEntity.status(200).body(" User Added!!");

        }

        @PutMapping("/user/{index}")
        public ResponseEntity updateUser(@Valid @RequestBody User userobj,@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            userService.editUser(index,userobj);
            return ResponseEntity.status(200).body("User updated!!");
        }

        @DeleteMapping ("/user/{index}")
        public ResponseEntity deleteUser(@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            userService.deleteUser(index);
            return ResponseEntity.status(200).body("Category Deleted!!");
        }

    @PostMapping("/addstock/{merchid}/{idproduct}/{quantity}")
    public ResponseEntity addToStock(@Valid @RequestBody int userid,@PathVariable int quantity,@PathVariable int idproduct,@PathVariable int merchid, Errors errors)
    {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addProductToStock(idproduct,merchid,userid,quantity);
      //  userService.addUser(userobj);
        return ResponseEntity.status(200).body(" add to stock!!");

    }


    @PostMapping("/addcart/{userid}/{idproduct}/{merchid}/{quantity}")
    public ResponseEntity addToCart(@PathVariable int userid,@PathVariable int quantity,@PathVariable int idproduct,@PathVariable int merchid, Errors errors)
    {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

       userService.BuyProduct(userid,idproduct,merchid,quantity);
        return ResponseEntity.status(200).body(" add to cart , User has the prod!!");

    }




    }// end


