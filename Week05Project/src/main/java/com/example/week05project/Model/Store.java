package com.example.week05project.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Store {

   /* Store class:
    id - name (Add all required validation)
   */
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    private String name;




   /* One To One
   Store - location*/
    @OneToOne( cascade = CascadeType.ALL, mappedBy="store")
    @PrimaryKeyJoinColumn
    private Location location;


    /* One To Many
     Store - Book*/

    @OneToMany(cascade= CascadeType.ALL, mappedBy="store")
    private List <Book> books;

    /* Many to Many
    Store - Customer*/
    @ManyToMany(cascade= CascadeType.ALL, mappedBy="stores")
    private List<Customer> customers;



}
