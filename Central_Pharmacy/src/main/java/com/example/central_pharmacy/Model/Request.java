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
public class Request {

    @Id
    private Integer id; //primary key
    private Integer hospitalId;//foreign key
    private Integer patientId;//foreign key
    private Integer medicineId;//foreign key

    private Integer quantity; // min=1
    private  String emergencyLevel;// rich, normal
    private double totalPrice;//  will be null then will reflect from medicine price
    private String status;// waiting ,rejected,approved,scheduled,delivered


}
