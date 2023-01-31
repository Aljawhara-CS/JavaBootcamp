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
    public ResponseEntity addUser(@Valid @RequestBody User user)

    {
  /*      if(errors.hasErrors())

        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);


        }*/

        userService.addUser(user);
        return ResponseEntity.status(200).body(" User Added!");

    }



    @PutMapping("/update/{id}")
    public  ResponseEntity updateUser(@PathVariable Integer id, @Valid@RequestBody User user)
    {



        userService.updateUser(user,id);
        return ResponseEntity.status(200).body("User Updated");

    /*    if(errors.hasErrors())

        {
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }*/


    /*    if(isUpdated)        boolean isUpdated=

                {
        }*/



      //  return ResponseEntity.status(400).body("Blog is not Updated; the id is not true");

    }


    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteUser(@PathVariable Integer id)
    {

        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User Deleted");

/*

      //  boolean isDeleted=

          if(isDeleted)
        {
        }
        return ResponseEntity.status(400).body("Wrong ID");*/

    }

    @GetMapping("/role/{role}")
    public ResponseEntity getRole(@PathVariable String role)
    {
        List<User>  roles= userService.findUserByRole(role);
        return  ResponseEntity.status(200).body(roles);

    }

    @GetMapping("/email/{email}")
    public ResponseEntity getEmail(@PathVariable String email)
    {
        User emails= userService.findUserByEmail(email);
        return  ResponseEntity.status(200).body(emails);

    }

   @GetMapping("/age/{age}")
    public ResponseEntity getAge(@PathVariable Integer age)
    {
        List<User> ages= userService.findUsersByAge(age);
        return  ResponseEntity.status(200).body(ages);

    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity Check(@PathVariable String username, @PathVariable String password)
    {
        User user= userService.findUsersByUsernameAndPassword(username,password);
        return  ResponseEntity.status(200).body(" You can login to the System");

    }



}
