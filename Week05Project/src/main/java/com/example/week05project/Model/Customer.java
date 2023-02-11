package com.example.week05project.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Customer {


  /*  Customer class:
    id - name - phoneNumber - email (Add all required validation)*/

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;


    @ManyToMany
    @JsonIgnore
    private List<Store> stores;
}
