package com.example.central_pharmacy.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //primary key
    @Column(columnDefinition = "int not null")
    private Integer hospitalId;//foreign key
    @Column(columnDefinition = "int not null")
    private Integer patientId;//foreign key
    @Column(columnDefinition = "int not null")

    private Integer medicineId;//foreign key
    @Column(columnDefinition = "int not null")
    @Min(1)
    private Integer quantity; // min=1
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp="(rush|normal)")
    private  String emergencyLevel;// rush, normal
    @Column(columnDefinition = "double not null")
    private double totalPrice;//  will be null then will reflect from medicine price
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp="(waiting|rejected|approved|scheduled|delivered)")
    private String status;// waiting ,rejected,approved,scheduled,delivered


}
