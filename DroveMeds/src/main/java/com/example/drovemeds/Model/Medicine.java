package com.example.drovemeds.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;//primary key
    @NotEmpty(message="Name should be not empty")
    @Column(columnDefinition = "varchar(100)  not null ")
    private String name;
    @NotNull(message="price should be not empty")
    @Positive(message="price must be Integer and grater than 0")
    private double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date expire;
    @NotNull(message="quantity should be not empty")
    @PositiveOrZero(message="quantity must be Integer")
    private Integer quantity;



    @Column(columnDefinition = "varchar(4)  not null ")
    @Pattern(regexp="(ml|mg)")

    private String unit;


    @NotNull(message="quantity should be not empty")
    @PositiveOrZero(message="quantity must be Integer")
    private Integer volume;


    @Column(columnDefinition = "varchar(10)  not null ")
    @Pattern(regexp="(Bage|Bottle)")
    private String packageType;

    @Column(columnDefinition = "varchar(30)  not null ")
    private String manufacturerName;

    @Column(columnDefinition = "varchar(30)  not null ")
    private String manufacturerCountry;


    @Column(columnDefinition = "varchar(70)  not null ")
    private String storageConditions;


  /*  @ManyToOne
    @JoinColumn(name ="requestId", referencedColumnName = "requestId")
    @JsonIgnore
    private Request request;  // Do we need it?*/


    @OneToOne( cascade = CascadeType.ALL, mappedBy="medicine")
    @PrimaryKeyJoinColumn
    private requestDetails detail;

}
