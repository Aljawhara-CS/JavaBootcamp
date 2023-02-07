package com.example.hw21.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AddressDTO {

    private Integer Teacher_id;
    private String area;
    private String street;
    private String buildingNumber;


}
