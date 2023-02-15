package com.example.javabootcamphw28.Service;


import com.example.javabootcamphw28.Exception.ApiException;
import com.example.javabootcamphw28.Model.Product;
import com.example.javabootcamphw28.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getProduct(){
        return productRepository.findAll();
    }


    public Product getProduct( Integer id){
        return productRepository.findProductById(id);
    }

    public void addProduct(Product product){

        productRepository.save(product);


    }


    public void updateProduct(Integer id, Product product){
        Product old = productRepository.findProductById(id);
        if (old==null) {
            throw new ApiException(" Product not found");

        }
        old.setQuantity(product.getQuantity());
        old.setName(product.getName());
        old.setPrice(product.getPrice());
        productRepository.save(old);

    }

    public void deleteProduct(Integer id){

        //In Delete endpoint, check Product status if its in progress or complete throw an exception
        Product product = productRepository.findProductById(id);


        if ( product!=null ) {

            throw new ApiException(" Product Not found ");

        }
        productRepository.deleteById(id);


    }
}
