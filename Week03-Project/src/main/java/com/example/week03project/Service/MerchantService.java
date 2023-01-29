package com.example.week03project.Service;

import com.example.week03project.POJO.Category;
import com.example.week03project.POJO.Merchant;
import com.example.week03project.POJO.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {


    ArrayList<Merchant> merchants= new ArrayList<>();
    ArrayList<Product> product = new ArrayList<>();
    ArrayList<Category> categories = new ArrayList<>();




    public ArrayList<Merchant> getMerchants() {
        return merchants;
    }

    public void addMerchant( Merchant merchant)
    {

        merchants.add(merchant);
    }

    public boolean editMerchant (Merchant merchant, int id)
    {

        for (int i=0;i<merchants.size();i++)
        {
            if(merchants.get(i).getId()==id)
                merchants.set(i, merchant);
            return true;
        }
        return  false;
    }


    public boolean deleteMerchant ( int id)
    {

        for (int i=0;i<merchants.size();i++)
        {
            if(merchants.get(i).getId()==id)
                merchants.remove(i);
            return true;
        }
        return  false;
    }



}
