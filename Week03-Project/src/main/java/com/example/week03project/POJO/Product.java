package com.example.week03project.POJO;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
public class Product {

/*    Product Class :

    id ( must not be empty , have to be 3 character long ).
    name ( must not be empty , have to be 3 length long ).
    price ( must not be empty , must be positive number ).
    categoryID ( must not be empty , have to be 3 character long ).*/


    @NotEmpty @Size(min=3,max=3)  private  char id;
    @NotEmpty @Size(min=3,max=3)private String name;
    @NotNull @Positive @Min(value = 0) private double price;

    @NotEmpty @Size(min=3,max=3) private char categoryID;




}
