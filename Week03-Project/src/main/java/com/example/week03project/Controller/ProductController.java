package com.example.week03project.Controller;

import com.example.week03project.POJO.Product;
import com.example.week03project.POJO.User;
import com.example.week03project.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor

public class ProductController {
       // ArrayList<Product> products= new ArrayList<>();

    private final ProductService productServobj;

        @GetMapping("/getproduct")
        public ResponseEntity getProduct()
        {
            ArrayList<Product> products=productServobj.getProducts();
            return  ResponseEntity.status(200).body(products);
        }

        @PostMapping("/addproduct")
        public ResponseEntity addProduct(@Valid @RequestBody Product productobj, Errors errors)
        {

            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            productServobj.addProduct(productobj);
            return ResponseEntity.status(200).body(" Product Added!!");

        }

        @PutMapping("/product/{index}")
        public ResponseEntity updateProduct(@Valid @RequestBody Product productobj,@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            productServobj.editProduct(productobj,index);
            return ResponseEntity.status(200).body("Product updated!!");
        }

        @DeleteMapping ("/product/{index}")
        public ResponseEntity deleteProduct(@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            productServobj.deleteProduct(index);
            return ResponseEntity.status(200).body("Product Deleted!!");
        }





    }// end


