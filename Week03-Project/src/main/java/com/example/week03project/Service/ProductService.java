package com.example.week03project.Service;

import com.example.week03project.POJO.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class ProductService {

    ArrayList<Product> products= new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }


    public void addProduct( Product product)
    {
        products.add(product);
    }

    public boolean editProduct( Product product, int id )
    {
        for (int i=0;i<products.size();i++)
        {
            if(products.get(i).getId()==id)
                products.set(i, product);
            return true;
        }
        return  false;


    }


    public boolean deleteProduct(int id )
    {
        for (int i=0;i<products.size();i++)
        {
            if(products.get(i).getId()==id)
                products.remove(i);
            return true;
        }
        return  false;


    }





}
