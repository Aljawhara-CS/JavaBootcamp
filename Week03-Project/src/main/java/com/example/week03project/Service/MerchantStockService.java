package com.example.week03project.Service;

import com.example.week03project.POJO.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

/*    public MerchantStockService(ArrayList<MerchantStock> merchantStocks) {
        this.merchantStocks = merchantStocks;
    }*/

    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }

    public void addMerchantStock (MerchantStock merchantStock)
    {
        merchantStocks.add(merchantStock);
    }

    public boolean editMerchantStock (MerchantStock merchantStock, int id)
    {

        for (int i=0;i<merchantStocks.size();i++)
        {
            if(merchantStocks.get(i).getId()==id)
                merchantStocks.set(i, merchantStock);
            return true;
        }
        return  false;
    }

    public boolean deleteMerchantStock (int id)
    {

        for (int i=0;i<merchantStocks.size();i++)
        {
            if(merchantStocks.get(i).getId()==id)
                merchantStocks.remove(i);
            return true;
        }
        return  false;
    }



}
