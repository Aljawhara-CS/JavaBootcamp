package com.example.central_pharmacy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    private Integer patientId;//primary key
    private String name;

    private String age;
    private Integer hospitalId; //foreign key
    private  String city;
    private  String nationalAddress;// 4 number
    private  String phone;
    private String email;
    private Integer insuranceId;//foreign key
    private double balance;

    private String StartDate;
    private String lastDate;

}
