package com.example.week03project.POJO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
/*

    Merchant Class :

    id ( must not be empty , have to be 3 character long ).
    name ( must not be empty , have to be 3 length long ).*/


    @NotEmpty
    @Size(min=3,max=3)  private long id;
    @NotEmpty @Size(min=3,max=3)  private String name;
    @NotEmpty @Size(min=3,max=3)  private long productid;


}
