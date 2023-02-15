package com.example.javabootcamphw28.Service;


import com.example.javabootcamphw28.Exception.ApiException;
import com.example.javabootcamphw28.Model.Customer;
import com.example.javabootcamphw28.Model.Request;
import com.example.javabootcamphw28.Model.Product;
import com.example.javabootcamphw28.Repository.RequestRepository;
import com.example.javabootcamphw28.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class RequestService {

    private  final RequestRepository requestRepository;

    private final ProductRepository productRepository;


/*    In Add order endpoint: calculate the total price , status by defalut new
    In Delete endpoint, check order status if its in progress or complete throw an exception
    Create endpoint that change order status(only admin can change it)
    Get order - customer - product by Id
    Get all customer orders*/






    public List<Request> getOrder(){
        return requestRepository.findAll();
    }


    public Request getOrder(Integer id){
        return requestRepository.findOrderById(id);
    }

    public void addOrder(Request request, Customer customer, Product product){

     //   In Add request endpoint: calculate the total price , status by defalut new

        request.setStatus("new");
        request.setCustomer(customer);
        request.setProduct(product);
      //  request.setDateReceived();
        requestRepository.save(request);
        totalPrice(request.getId());


    }

  /*  public void addProdToOrd(Request request, Customer user, Product product) {

        //   In Add request endpoint: calculate the total price , status by defalut new

        Request found = requestRepository.findOrderById(request.getId());

        if (found == null)
        {

            request.setStatus("new");
            request.setCustomer(user);
            request.setProduct(product);
            requestRepository.save(request);
            totalPrice(request.getId());

        }


        }

    }*/



    public void updateOrder(Integer id, Request Request){
        Request old = requestRepository.findOrderById(id);
        if (old==null) {
            throw new ApiException(" Request not found");

        }
        old.setQuantity(Request.getQuantity());

        requestRepository.save(old);

    }

    public void deleteOrder(Integer id){

        //In Delete endpoint, check request status if its in progress or complete throw an exception
        Request request = requestRepository.findOrderById(id);


        if ( (request.getStatus().equals("inProgress")) ||  (request.getStatus().equals("completed")) ) {

            throw new ApiException(" Request Can not be deleted ");

        }
        requestRepository.deleteById(id);


    }

    public void totalPrice( Integer orderId){

        Request request = requestRepository.findOrderById(orderId);
        if (request ==null) {
            throw new ApiException(" Request not found");

        }

        request.setTotalPrice(request.getProduct().getPrice()*request.getQuantity());
        requestRepository.save(request);




    }


    public void changeStatus(Integer orderId, Customer customer)
    {

      //  Create endpoint that change order status(only admin can change it)

        if (customer.getRole().equals("ADMIN"))

        {
         //   inProgress  completed

            Request request = requestRepository.findOrderById(orderId);
            if (request ==null) {
                throw new ApiException(" Request not found");
            }

            int productId= request.getProduct().getId();

            Product product = productRepository.findProductById(productId);

            if( (request.getQuantity() < product.getQuantity()) || (!request.getStatus().equals("completed")) )
            {
                    request.setStatus("inProgress");
                    product.setQuantity(product.getQuantity()- request.getQuantity());
            }
            else  if( request.getStatus().equals("inProgress"))
            request.setStatus("completed");




        }



    }








}
