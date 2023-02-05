package com.example.hw19.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Director {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    @Min(3)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, max = 20)
    private String name;
}
