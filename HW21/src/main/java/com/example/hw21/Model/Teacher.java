package com.example.hw21.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher {

    //Teacher Class :
    //id , name , age , email , salary ( Add all required validation )

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @Column(columnDefinition = "varchar(20) not null")
    private String age;
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @Column(columnDefinition = "int not null")
    private int salary;



    @OneToOne( cascade = CascadeType.ALL, mappedBy="teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="teacher")
    private List  <Course> courses;



}
