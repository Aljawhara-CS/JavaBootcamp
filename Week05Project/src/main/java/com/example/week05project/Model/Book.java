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

public class Book {

    // id - name - bookCount - genre (Add all required validation)


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Column(columnDefinition = "Int not null")
    private Integer bookCount;

    @Column(columnDefinition = "varchar(20) not null")
    private String genre;




    @ManyToOne
    @JoinColumn(name ="store_id", referencedColumnName = "id")
    @JsonIgnore
    private Store store;


}
