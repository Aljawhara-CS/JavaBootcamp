package com.example.week05project.Service;

import com.example.week05project.Exception.ApiException;
import com.example.week05project.Model.Book;
import com.example.week05project.Model.Customer;
import com.example.week05project.Model.Store;
import com.example.week05project.Repostry.CustomerRepository;
import com.example.week05project.Repostry.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CustomerService {


    public final CustomerRepository  customerrepository;
    public  final StoreService storeService;

    public final  StoreRepository storeRepository;


    public List<Customer> getCustomers()
    {

        return customerrepository.findAll();
    }

    public  void  addCustomer(Customer Customer)

    {
        customerrepository.save(Customer);

    }

    public  void  UpdateCustomer(Customer Customer, Integer id)
    {

        Customer old= customerrepository.findCustomerById(id);

        if(old==null) {
            throw new ApiException(" Customer not found");

        }

        old.setName(Customer.getName());
        customerrepository.save(old);

    }


    public  void  DeleteCustomer (Integer id)
    {
        Customer found= customerrepository.findCustomerById(id);
        if(found!=null)
        {
            customerrepository.deleteById(id);
        }

        else throw new ApiException(" Customer not found");

    }

    public void assignStoreWithCustomer(Integer store_id, Integer customer_id)
    {

        Store store = storeService.getStoreById(store_id);
        Customer customer=customerrepository.findCustomerById(customer_id);




        if (store==null || customer==null)
        {
            throw new ApiException(" Can not Assigned, Objects not found  ");

        }

        customer.getStores().add(store);
        customerrepository.save(customer);


        store.getCustomers().add(customer);
        storeRepository.save(store);




    }



/*

   // Create endpoint that takes Customer id and major and change the Customer major
    // ( changing the major will drop all the cousres that the Customer attended to )


    public void ChangeCustomerMajor( Integer Customer_id, String newMajor)
    {
        Customer Customer= customerrepository.findCustomerById(Customer_id);

        if(Customer!=null)
        {

            for (int i=0; i<Customer.getCourse().size();i++)
            {

                Customer.getCourse().remove(i);

            }
            Customer.setMajor(newMajor);
            customerrepository.save(Customer);
        }

        else throw new ApiException(" Customer not found");


    }



*/










}
