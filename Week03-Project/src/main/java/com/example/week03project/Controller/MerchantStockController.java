package com.example.week03project.Controller;

import com.example.week03project.POJO.MerchantStock;
import com.example.week03project.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor

public class MerchantStockController {

     //   ArrayList<MerchantStock> stock = new ArrayList<>();
        private final MerchantStockService stockobj;

        @GetMapping("/getstock")
        public ResponseEntity getStock()
        {
            ArrayList<MerchantStock> stock = stockobj.getMerchantStocks();
            return  ResponseEntity.status(200).body(stock);
        }

        @PostMapping("/addstock")
        public ResponseEntity addStock(@Valid @RequestBody MerchantStock StockObj, Errors errors)
        {

            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            stockobj.addMerchantStock(StockObj);
            return ResponseEntity.status(200).body(" Stock Added!!");

        }

        @PutMapping("/stock/{index}")
        public ResponseEntity updateStock(@Valid @RequestBody MerchantStock StockObj,@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            stockobj.editMerchantStock(StockObj,index);
            return ResponseEntity.status(200).body("Stock updated!!");
        }

        @DeleteMapping ("/stock/{index}")
        public ResponseEntity deleteStock(@PathVariable int index,Errors errors)
        {
            if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(400).body(message);
            }
            stockobj.deleteMerchantStock(index);
            return ResponseEntity.status(200).body("Stock Deleted!!");
        }





    }// end


