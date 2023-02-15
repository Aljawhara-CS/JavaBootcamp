package com.example.javabootcamphw28.Repository;

import com.example.javabootcamphw28.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Customer findUsersById(Integer id);

    Customer findCustomerByUsername(String username);
}

