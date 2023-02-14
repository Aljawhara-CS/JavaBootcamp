package com.example.javabootcamphw27.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Blog {
/*    Blog Class:
    id - title - body (Add All validation required)*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @NotEmpty(message = "title should be not empty")
    private String title;

    @NotEmpty(message = "body should be not empty")
    private  String body;

   /* One to Many Relation:
    User - Blog*/


    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user ;

}
