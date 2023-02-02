package com.example.central_pharmacy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;//primary key
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "varchar(20) not null")
    private String age;
    @Column(columnDefinition = "int not null")

    private Integer hospitalId; //foreign key
    @Column(columnDefinition = "varchar(20) not null")
    private  String city;
    @Column(columnDefinition = "varchar(4) not null")

    private  String nationalAddress;// 4 number
    @Column(columnDefinition = "varchar(10) not null")

    private  String phone;
    @Column(columnDefinition = "varchar(20) not null")
    private String email;

    @Column(columnDefinition = "int not null")
    private Integer insuranceId;//foreign key

    @Column(columnDefinition = "double not null")
    private double balance;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date StartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date lastDate;

}
