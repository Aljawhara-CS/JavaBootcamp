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


    ArrayList<Product> products = product.getProducts();
    ArrayList<MerchantStock> merchantStocks = merchantStockServiceobj.getMerchantStocks();
    ArrayList<Merchant> merchants=merchantService.getMerchants();
    ArrayList<User> users= new ArrayList<>();





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

    public boolean addProductToStock(Product prodobj , MerchantStock merchobj, User user, char merchantid ) // int quantity,
    {


        if(user.getRole().equals("Admin")) // authentication

        {
            // Update Stock

            for (int i=0; i<merchantStocks.size(); i++)

            {
                if (merchantStocks.get(i).getId()==merchobj.getId())
                {

                    merchantStocks.set(i,merchobj);
                    return true;
                }

            }

            // First time to add Product to Stock

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
            }


        }

        return  false;

    }


    public boolean BuyProduct(int userid , long productid , int merchantid, int quantity)
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
            if (merchantStocks.get(i).getMerchantid()==merchantid)
            {
             //   int size = Count(merchants.get(merchantid).getProductid());
                for (int j=i;j<= products.size();j++)

                      //  merchants.get(merchantid).getProductid();j++)
                       // product.size();j++)
                    {

                    if ((merchantStocks.get(j).getProductid() == productid) && (merchantStocks.get(j).getStock()>=quantity))
                    {
                        MerchantStock obj= new MerchantStock(j,productid,merchantid,(merchantStocks.get(j).getStock()-quantity));
                        totalPrice= products.get(j).getPrice()*quantity;
                       if(users.get(userid).getBalance() >= totalPrice) //ID user
                       {
                           newBalance= users.get(j).getBalance()-totalPrice;

                           merchantStocks.set(j,obj); //update stock
                           users.get(userid).setBalance(newBalance); //update balance
                           return true;

                       }
                       else return false;
                    } else return false;
                }//End inner loop
            }// End if
        }// End first loop
        return  false;

    }


}
