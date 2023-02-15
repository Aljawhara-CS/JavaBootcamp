package com.example.javabootcamphw28.Service;

import com.example.javabootcamphw28.Exception.ApiException;
import com.example.javabootcamphw28.Model.Customer;
import com.example.javabootcamphw28.Model.Request;
import com.example.javabootcamphw28.Repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CustomerService {



    private final CustomerRepository customerRepository;


    public List<Customer> getUser(){
        return customerRepository.findAll();
    }


    public Customer getUser(Integer id){
        return customerRepository.findUsersById(id);
    }

    public void addUser(Customer customer){

        customer.setRole("CUSTOMER");
        customerRepository.save(customer);


    }



    public void register(Customer myUser) {
       String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setRole("CUSTOMER");
        myUser.setPassword(hashedPassword);
        customerRepository.save(myUser);
    }



    public void updateUser(Integer id, Customer customer){
        Customer old = customerRepository.findUsersById(id);
        if (old==null) {
            throw new ApiException(" Customer not found");

        }
        old.setRole(customer.getRole());
        customerRepository.save(old);

    }

    public void deleteUser(Integer id){

        Customer customer = customerRepository.findUsersById(id);


        if ( customer ==null ) {

            throw new ApiException(" Customer Not found ");

        }
        customerRepository.deleteById(id);


    }


//Get all customer orders

    public List<Request> getCustomerOrders(Customer customer){

        Customer found = customerRepository.findUsersById(customer.getId());


        if ( found ==null ) {

            throw new ApiException(" Customer Not found ");

        }

       return found.getRequests();

    }



}
