package com.example.hw21.Model;

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

public class Student {


  //  Student Class : ID , name , age , major ( all should not be empty )


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String age;
    private String major;

    @ManyToMany
    @JsonIgnore
    private List<Course> course;
}
