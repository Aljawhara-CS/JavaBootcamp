package com.example.week05project.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Location {

   /* Location class:
    area - street (Add all required validation) all required validation )*/
    @Id
    private Integer id;
    private String area;
    private String street;


   @OneToOne
   @MapsId
   @JsonIgnore
   private Store store;


}
