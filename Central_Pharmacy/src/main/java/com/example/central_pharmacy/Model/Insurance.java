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
public class Insurance {

    @Id
    private Integer insuranceId;
    private String name;
    private String  type;
    private Integer patientId;//foreign key



}
