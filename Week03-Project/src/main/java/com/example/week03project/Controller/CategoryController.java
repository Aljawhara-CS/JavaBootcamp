package com.example.week03project.Controller;
import com.example.week03project.POJO.Category;
import com.example.week03project.Service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/amazon")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryobj;
    @GetMapping("/getcategory")
    public ResponseEntity getCategories()
    {
        ArrayList <Category> category = categoryobj.getCategories();
        return  ResponseEntity.status(200).body(category);
    }

    @PostMapping("/addcategory")
    public ResponseEntity addCategory( @RequestBody Category category, Errors errors)
    {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryobj.addCategory(category);
        return ResponseEntity.status(200).body(" Category Added!!");

    }

    @PutMapping("/category/{index}")
    public ResponseEntity updateCategory( @RequestBody Category category,@PathVariable int index,Errors errors)
    {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryobj.editCategory(index,category);
        return ResponseEntity.status(200).body("Category updated!!");
    }

    @DeleteMapping ("/category/{index}")
    public ResponseEntity deleteCategory(@PathVariable int index,Errors errors)
    {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        categoryobj.deleteCategory(index);
        return ResponseEntity.status(200).body("Category Deleted!!");
    }





}// end
