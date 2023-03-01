package com.example.drovemeds.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class requestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;


    @Min(1)
    @NotNull(message="quantity should be not empty")
    @PositiveOrZero(message="quantity must be Integer")
    private Integer quantity;

   @ManyToOne
    @JoinColumn(name ="request_id", referencedColumnName = "requestId")
    @JsonIgnore
    private Request request;


    @OneToOne
    @MapsId
    @JsonIgnore
    private Medicine medicine;







}
