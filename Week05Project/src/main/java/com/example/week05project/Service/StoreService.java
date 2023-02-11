package com.example.week05project.Service;


import com.example.week05project.Exception.ApiException;
import com.example.week05project.Model.Book;
import com.example.week05project.Model.Customer;
import com.example.week05project.Model.Store;
import com.example.week05project.Repostry.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class StoreService {


    public final StoreRepository storerepository;



    public List<Store> getStores()
    {

        return storerepository.findAll();
    }

    public Store getStoreById(Integer storeId){
        Store store = storerepository.findById(storeId).orElse(null);
        if(store == null)
            throw new ApiException(" Store not found");
        return store;
    }

    public  void  addStore(Store Store)

    {
        storerepository.save(Store);

    }

    public  void  UpdateStore(Store Store, Integer id) {

        Store old= getStoreById(id);
        old.setName(Store.getName());
        storerepository.save(old);
    }



    public  void  DeleteStore (Integer id) {
        getStoreById(id);
        storerepository.deleteById(id);
    }


   // Create endpoint that takes storeid and return all the books


    public  List<Book>  getBooksByStoreId(Integer id) {
        Store store = getStoreById(id);
        return store.getBooks();
//        List<Book> books= new ArrayList<>();

//        if(store==null)
//        {
//            throw new ApiException("  not found  ");
//
//        }
//
//
//        for (int i=0; i<store.getBooks().size();i++) {
//
//            books.add(store.getBooks().get(i));
//
//        }
//
//        return books;


    }



   // Create endpoint that takes storeid and return all customers


    public  List<Customer>  getCustomersByStoreId(Integer id)
    {

        Store store= getStoreById(id);
        return store.getCustomers();
      /*  List<Customer> customers= new ArrayList<>();

        if(store==null)
        {
            throw new ApiException("  not found  ");

        }


        for (int i=0; i<store.getCustomers().size();i++) {

            customers.add(store.getCustomers().get(i));

        }

        return customers;*/


    }



/*
   // Create endpoint that takes Store id and return All Store details

    public  Store  getStoreDetails (Integer id)
    {
        Store Store= storerepository.findStoreById(id);
        Address address= addressRepository.findAddressById(id);

        if(Store==null || address==null)
        {
                     throw new ApiException(" id not found");
        }

        Store.setAddress(address);
        return  Store;


    }

    //Create endpoint that takes Store id and return All Store details



    public  Store getStoreInfo( Integer id)
    {

        Store Store= storerepository.findStoreById(id);

        if(Store==null)
        {
            throw new ApiException(" id not found");
        }

        return Store;

    }

*/











}
