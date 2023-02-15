package com.example.javabootcamphw28.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Request {

    //id - quantity - totalPrice - dateReceived - status(new-inProgress-completed) (Add All Required Validation)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "int not null")
    @Min(1)
    private  Integer quantity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date dateReceived;
    @Column(columnDefinition = "double  null")
    private double totalPrice;//  will be null then will reflect from product price

    @Pattern(regexp="(new|inProgress|completed)")
    private String status;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="product_id", referencedColumnName = "id")
    @JsonIgnore
    private  Product product;




}
