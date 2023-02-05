package com.example.hw19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Column(columnDefinition = "int not null")
    @Min(3)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    @Size(min = 2, max = 20)
    private String name;
    @Column(columnDefinition = "varchar(6) not null")
    @Pattern(regexp="(Drama|Action|Comedy)")
    private String genre;
    @Column(columnDefinition = "int not null")
    @Min(1)
    @Max(5)
    private Integer rating;

    @Min(60)
    private String duration;

   /* @ManyToOne
    @JoinColumn(name = "id")*/
    private Integer directorID;


}
