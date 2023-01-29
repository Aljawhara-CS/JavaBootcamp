package com.example.week03project.POJO;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

/*    id ( must not be empty , have to be 3 character long ).
    username ( must not be empty , have to be 5 length long ).
    password ( must not be empty , have to be 6 length long , must have characters and digits ).
    email ( must not be empty , must be valid email ).
    role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
    balance ( must not be empty , have to be positive ).*/




    @NotEmpty @Size(min=3,max=3) private long id;
    @NotEmpty @Size(min=5,max=5) private String username;
    @NotEmpty @Size(min=6,max=6)  private String password;
    private String email;
    @Pattern(regexp="(Admin|Customer)")
    private String role;
    @NotNull @Positive @Min(value = 0)
    private double balance;








}
