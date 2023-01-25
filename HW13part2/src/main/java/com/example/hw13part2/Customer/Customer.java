package com.example.hw13part2.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customer {
    private int id;
    private String username;
    private double balance;
}
