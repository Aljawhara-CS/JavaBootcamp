package com.example.hw14.POJO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
public class Employees {
    @NotNull(message = "ID should be not null")
  //  @Size(min=2, message = "Employees ID should be more than 2")
    @Min(2)
    private int id;
    @NotEmpty(message = "Name should be not Empty")
    @Size(min=4, message = "Employees name should be more than 3")

    private String name;
    @NotNull(message = "age should be not null")
    @Min(25)//, message = "Employees age should be more than 25")
    private int age;

   @NotEmpty(message = "age should be not Empty")
   @Pattern(regexp="(supervisor|coordinator)")
    private String role;
    @AssertFalse
    private boolean onLeave;

    @NotNull(message = "employmentYear should be not null")
    @Range(min = 2000, max = 2023)
    @DateTimeFormat(pattern = "yyyy")
    private int employmentYear;
    @NotNull(message = "annualLeave should be not null")
    private int annualLeave;

}



/*Employees class: ID , name , age , role, onLeave, employmentYear ,annualLeave

Validation :

ID :
Cannot be null

Length more than 2

name :
Cannot be null

Length more than 4

age :
Cannot be null

It has to be number

It must be more than 25

position :
Cannot be null

must be supervisor or coordinator only

onLeave :
must be false

employmentYear :
Cannot be null

it has to be number

must be a valid year

annualLeave:
Cannot be null

it has to be number*/
