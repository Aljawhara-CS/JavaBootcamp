package com.example.hw17.Controller;

import com.example.hw17.Model.User;
import com.example.hw17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser()
    {
        List<User> user= userService.getUser();
        return  ResponseEntity.status(200).body(user);

    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors)

    {
        if(errors.hasErrors())

        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);


        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(" User Added!");

    }



    @PutMapping("/update/{id}")
    public  ResponseEntity updateUser(@PathVariable Integer id, @Valid@RequestBody User user, Errors errors)
    {
        if(errors.hasErrors())

        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }


        boolean isUpdated= userService.updateUser(user,id);

        if(isUpdated)
        {
            return ResponseEntity.status(200).body("User Updated");
        }



        return ResponseEntity.status(400).body("Blog is not Updated; the id is not true");

    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteUser(@PathVariable Integer id)
    {

        boolean isDeleted= userService.deleteUser(id);

        if(isDeleted)
        { return ResponseEntity.status(200).body("User Deleted");}
          return ResponseEntity.status(400).body("Wrong ID");

    }



}
