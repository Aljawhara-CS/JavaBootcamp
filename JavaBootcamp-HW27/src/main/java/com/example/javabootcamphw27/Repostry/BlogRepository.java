package com.example.javabootcamphw27.Repostry;

import com.example.javabootcamphw27.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {


    Blog findBlogById(Integer id);
    List<Blog> findAllByUserId(Integer userId);

    Blog findBlogByTitle(String title);



}
