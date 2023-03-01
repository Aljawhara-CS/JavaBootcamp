package com.example.drovemeds.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;//primary key
    @Column(columnDefinition = "varchar(20) not null")
    private String firstName;
    @Column(columnDefinition = "varchar(20) not null")
    private String lastName;


    @Column(columnDefinition = "varchar(20) not null")
    private String age;



    @Column(columnDefinition = "varchar(20)  null")
    private  String country;// read it from hospital

    @Column(columnDefinition = "varchar(20)  null")
    private  String city; // read it from hospital
    @Column(columnDefinition = "varchar(4) not null")

    private  String nationalAddress;// 4 number
    @Column(columnDefinition = "varchar(10) not null")

    private  String phone;
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp="(M|F)")
    private String gender;

    @Column(columnDefinition = "double not null")
    private double balance;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date lastDate;



    @OneToMany(cascade= CascadeType.ALL, mappedBy="patient")
    private List<Request> requests;



    @ManyToOne
    @JoinColumn(name ="hospitalId", referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;





}

