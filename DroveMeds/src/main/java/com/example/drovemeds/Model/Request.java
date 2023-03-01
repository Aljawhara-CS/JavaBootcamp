package com.example.drovemeds.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer requestId; //primary key

    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp="(rush|normal|refilled)")
    private  String emergencyLevel;// rush, normal, refilled
    @Column(columnDefinition = "double  null")
    private double totalPrice;//  will be null then will reflect from medicine price
    @Column(columnDefinition = "varchar(20)  null")
    @Pattern(regexp="(waiting|rejected|approved|lack|scheduled|delivered)")
    private String status;// waiting ,rejected,approved,scheduled,delivered


    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp="(Morning|Evening|AfterEvening)")
    private String deliveryTime;
    
    @Column(columnDefinition = "varchar(300)  null")
    private String note;

    @Column(columnDefinition = "varchar(300)  not null")      // need to add instructions.
    private String instructions;

    private String submittingDate;

    private String day;




    @OneToMany(cascade= CascadeType.ALL, mappedBy="request")
    private List <requestDetails> details;


    @ManyToOne
    @JoinColumn(name ="patientId", referencedColumnName = "patientId")
    @JsonIgnore
    private Patient patient;


    @ManyToOne
    @JoinColumn(name ="userId", referencedColumnName = "userId")
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name ="hospitalId", referencedColumnName = "id")
    @JsonIgnore
    private Hospital hospital;


    @OneToOne( cascade = CascadeType.ALL, mappedBy="request")
    @PrimaryKeyJoinColumn
    private DeliverySchedule deliverySchedule;






}
