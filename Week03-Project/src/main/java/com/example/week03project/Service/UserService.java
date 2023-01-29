package com.example.week03project.Service;


import com.example.week03project.POJO.Merchant;
import com.example.week03project.POJO.MerchantStock;
import com.example.week03project.POJO.Product;
import com.example.week03project.POJO.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor

public class UserService {


    private final ProductService product;
    private final MerchantStockService merchantStockServiceobj;
    private  final  MerchantService  merchantService;
    private  final UserService user;




    ArrayList<Product> products = product.getProducts();
    ArrayList<MerchantStock> merchantStocks = merchantStockServiceobj.getMerchantStocks();
    ArrayList<Merchant> merchants=merchantService.getMerchants();

    ArrayList<User> users= user.getUsers();





    public ArrayList<User> getUsers() {
        return users;
    }


    public void addUser(User user)
    {

        users.add(user);
    }


    public boolean editUser (int id, User user)
    {
        for (int i=0;i<users.size();i++)
        {
            if(users.get(i).getId()==id)
                users.set(i, user);
            return true;
        }
        return  false;

    }

    public boolean deleteUser (int id)
    {
        for (int i=0;i<users.size();i++)
        {
            if(users.get(i).getId()==id) // user should not be deleted for the history
                users.remove(i);
            return true;
        }
        return  false;

    }

    public boolean addProductToStock(int prodid , int merchid, int userid, int quantity)
    {


        if(users.get(userid).getRole().equals("Admin")) // authentication

        {
            // Update Stock

            for (int i=0; i<merchantStocks.size(); i++)

            {
                if (merchantStocks.get(i).getId()==merchid && merchantStocks.get(i).getId()==prodid)
                {

                    //merchantStocks.set(i,merchobj);
                    long id = merchantStocks.size()+1;

                    MerchantStock obj = new MerchantStock(id,prodid,merchid,quantity);
                    merchantStockServiceobj.editMerchantStock(obj,i);
                    return true;
                }

            }

/*            // First time to add Product to Stock

            for (int i=0; i<products.size(); i++)
            {
               if(products.get(i).getId()==prodobj.getId())

               {
                 // if first time system has to add product id, Create a new  id, add merchantid, add new quantity
                   long id = merchantStocks.size()+1;
                   merchobj.setId(id);
                 //  MerchantStock obj =new MerchantStock(id,prodobj.getId(),merchantid,quantity);
                   merchantStocks.add(merchobj);
                   return true;

               }
            }*/


        }

        return  false;

    }


    public boolean BuyProduct(int userid , int productid , int merchantid, int quantity)
    {
       /* Create endpoint where user can buy a product directly
        this endpoint should accept userid , product id , merchantid.

            - check if all the given id is valid or not
            - check if the merchant have the product in stock or return bad request.
            - reduce the stock from the MerchantStock.

            - deducted the price of the product from the user balance.
            - if balance is less than the product price return bad request.*/

        double totalPrice;
        double newBalance;

        for (int i=0; i<merchantStocks.size(); i++)

        {
            if (merchantStocks.get(i).getMerchantid()==merchantid && merchantStocks.get(i).getProductid()==productid)
            {

                    if (merchantStocks.get(i).getStock()>=quantity)
                    {
                        MerchantStock obj= new MerchantStock(i,productid,merchantid,(merchantStocks.get(i).getStock()-quantity));
                        totalPrice= products.get(productid).getPrice()*quantity;
                       if(users.get(userid).getBalance() >= totalPrice) //ID user
                       {
                           newBalance= users.get(userid).getBalance()-totalPrice;

                           merchantStocks.set(i,obj); //update stock
                           users.get(userid).setBalance(newBalance); //update balance
                           return true;

                       }
                       else return false;
                    } else return false;
            }// End if
        }// End first loop
        return  false;

    }


}
