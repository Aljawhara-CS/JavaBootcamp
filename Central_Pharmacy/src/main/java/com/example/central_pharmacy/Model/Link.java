package com.example.central_pharmacy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Link {

    private Integer requestId;//foreign key
    private Integer medicineId;//foreign key


}
