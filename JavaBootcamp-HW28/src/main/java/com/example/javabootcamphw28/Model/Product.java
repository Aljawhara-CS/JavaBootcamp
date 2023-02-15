package com.example.javabootcamphw28.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Product {

//    id - name - price (Add All Required Validation)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String name;

    @Column(columnDefinition = "double  not null")
    private double price;

    @Column(columnDefinition = "int not null")
    @Min(1)
    private  Integer quantity;


    //Product - Request (One to Many)
    @OneToMany(cascade= CascadeType.ALL, mappedBy="product")
    private List<Request> requests;


}
