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

public class Course {

    //Course Class :
    //
    //id , name ( all should not be empty )

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @ManyToOne
    @JoinColumn(name ="teacher_id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(cascade= CascadeType.ALL, mappedBy="course")
    private List<Student> students;




}
