package com.example.javabootcamphw28.Controller;


import com.example.javabootcamphw28.Model.Product;
import com.example.javabootcamphw28.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor

public class ProductController {
        private final ProductService productService;

        @GetMapping("")
        public ResponseEntity getProduct(){
            List<Product> products = productService.getProduct();
            return ResponseEntity.status(200).body(products);
        }

        @PostMapping("")
        public ResponseEntity addProduct(@Valid @RequestBody Product product)
        {
            productService.addProduct(product);
            return ResponseEntity.status(200).body("Product Added");
        }

        @PutMapping("/{id}")
        public ResponseEntity updateProduct(@Valid @RequestBody Product Product, @PathVariable Integer id){
            productService.updateProduct(id, Product);
            return ResponseEntity.status(200).body("Product Updated");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteProduct(@PathVariable Integer id){

            productService.deleteProduct(id);
            return ResponseEntity.status(200).body("Product Deleted");}



}
