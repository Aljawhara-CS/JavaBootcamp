package com.example.drovemeds.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//primary key

    @Column(columnDefinition = "varchar(100) not null")
    private String name;

    @Column(columnDefinition = "varchar(30) not null")
    private String shortCode;

    @Column(columnDefinition = "varchar(30) not null")
    private String city;


    @Column(columnDefinition = "varchar(30) not null")
    private String country;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="hospital")
    private List<Patient> patients;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="hospital")
    private List<HospitalAdmin> hospitalAdmins;


    @OneToMany(cascade= CascadeType.ALL, mappedBy="hospital")
    private List<Request> requests;



}

