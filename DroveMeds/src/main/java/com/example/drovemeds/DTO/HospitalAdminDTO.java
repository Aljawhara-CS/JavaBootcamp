package com.example.drovemeds.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class HospitalAdminDTO {

    //private Integer hospital_id;

    private Integer userId;
    private String first_name;
    private String last_name;

    private String status;
    private String type_user;
    private String    email;
    private String password;

    private Integer hospitalId;




}
