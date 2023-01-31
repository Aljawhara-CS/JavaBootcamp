package com.example.hw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

  //  User class: ID , name , username , password, email ,role, age

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer  id;

    @Column(columnDefinition = "varchar(30) not null unique")
    @Size(min = 4, max=30)
    private String name;

    @Column(columnDefinition = "varchar(30) not null unique")
    @Size(min = 4, max=30)

    private String username;

    @Email
    @Column(columnDefinition = "varchar(30) not null unique" )
    private String email;

    @Column(columnDefinition = "varchar(30) not null")
    private String password;


    @Column(columnDefinition = "varchar(30)not null check (role= 'Admin' OR role='User')")
    @Pattern(regexp="(Admin|User)")
    private String role;

    @Column(columnDefinition = " int not null")
    private Integer age;


}
