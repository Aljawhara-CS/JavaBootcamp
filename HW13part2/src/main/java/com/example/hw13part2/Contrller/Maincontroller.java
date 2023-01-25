package com.example.hw13part2.Contrller;
import com.example.hw13part2.Customer.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/main")
public class Maincontroller {

        ArrayList <Customer> customerList=new ArrayList();

        @GetMapping("/customer")
        public ArrayList<Customer> getCustomers(){
            return customerList;
        }

        @PostMapping("/new")
        public String addCustomer(@RequestBody Customer customer){
            customerList.add(customer);
            return  "Customer Added !";
        }

        @PutMapping("/{index}")
        public String updateCustomer(@RequestBody Customer customer, @PathVariable int index){
            customerList.set(index,customer);
            return "Customer updated !";
        }

        @DeleteMapping("/{index}")
        public String deleteCustomer( @PathVariable int index){
            customerList.remove(index);
            return "Customer deleted !";
        }

        @PostMapping("/deposit")
        public String deposit(@RequestBody int id,@RequestBody double amount){
            for (int i = 0; i < customerList.size(); i++) {
                if(customerList.get(i).getId()==id){
                    double oldBalance=customerList.get(i).getBalance();
                    customerList.get(i).setBalance(oldBalance+amount);
                    return "Deposit Done";
                }
            }
            return "You entered wrong id";
        }

@PostMapping("/withdraw")
        public String withdraw(@RequestBody double amount, @RequestBody int id){
          for (int i = 0; i < customerList.size(); i++) {
                if(customerList.get(i).getId()==id){
                    double oldBalance=customerList.get(i).getBalance();
                    customerList.get(i).setBalance(oldBalance-amount);
                    return "Withdraw Done";
                }
            }
            return "You entered wrong id";
        }



    }




