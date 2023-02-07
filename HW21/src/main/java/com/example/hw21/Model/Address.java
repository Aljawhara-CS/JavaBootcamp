package com.example.hw21.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    //Address Class :
    //area , street , buildingNumber ( Add all required validation )
    @Id
    private Integer id;
    private String area;
    private String street;
    private String buildingNumber;


   @OneToOne
   @MapsId
   @JsonIgnore
   private Teacher teacher;


}
