package com.example.week03project.POJO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

   /* MerchantStock Class :

    id ( must not be empty , have to be 3 character long ).
    productid ( must not be empty , have to be 3 character long ).
    merchantid ( must not be empty , have to be 3 length long ).
    stock ( must not be empty , have to be more than 10 at start ).
    */

    @NotEmpty @Size(min=3,max=3)  private long id;
    @NotEmpty @Size(min=3,max=3)  private long productid;
    @NotEmpty @Size(min=3,max=3)  private long merchantid;

    @NotEmpty @Min(11)  private int stock;



}
