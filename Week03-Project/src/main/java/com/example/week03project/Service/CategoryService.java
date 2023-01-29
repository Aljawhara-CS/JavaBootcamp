package com.example.week03project.Service;


import com.example.week03project.POJO.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {


    ArrayList<Category>  categories= new ArrayList<>();


    public ArrayList<Category> getCategories() {
        return categories;
    }


    public void addCategory( Category category)
    {
        categories.add(category);
    }

    public boolean editCategory( int id, Category category)
    {

        for (int i=0;i<categories.size();i++)
        {
            if(categories.get(i).getId()==id)
             categories.set(i, category);
            return true;
        }
        return  false;
    }


    public boolean deleteCategory( int id)
    {

        for (int i=0;i<categories.size();i++)
        {
            if(categories.get(i).getId()==id)
                categories.remove(i);
            return true;
        }
        return  false;
    }





}
