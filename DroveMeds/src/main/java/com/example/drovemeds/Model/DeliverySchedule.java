package com.example.drovemeds.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor

public class DeliverySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //primary key


    @Column(columnDefinition = "varchar(50) not null")
    private String Day;

    @Column(columnDefinition = "varchar(100) not null")
    private String TimeDelivery;

    private String dateDelivery;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Request request;


}