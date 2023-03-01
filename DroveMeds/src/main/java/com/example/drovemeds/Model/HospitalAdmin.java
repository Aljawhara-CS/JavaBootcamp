package com.example.drovemeds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class HospitalAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;//primary key
    @Column(columnDefinition = "varchar(20) not null")
    private String first_name;
    @Column(columnDefinition = "varchar(20) not null")
    private String last_name;
    @Column(columnDefinition = "varchar(20)  null")
    @Pattern(regexp="(waiting|Approved|rejected)")
    private String status;// waiting ,rejected,approved



    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name ="hospitalId", referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;


}
