package com.example.javabootcamphw27.Controller;


import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Model.User;
import com.example.javabootcamphw27.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

   private final BlogService blogService;

   @GetMapping()
    public ResponseEntity getBlog()
   {
       List <Blog> blogs= blogService.getBlog();
       return  ResponseEntity.status(200).body(blogs);

   }

   @PostMapping()
   public ResponseEntity addBlog(@Valid@RequestBody Blog blog,@AuthenticationPrincipal User myUser)

   {

       blogService.addBlog(blog,myUser.getId() );
       return ResponseEntity.status(200).body(" Blog Added!");

   }

   @PutMapping("/{id}")
    public  ResponseEntity updateBlog(@PathVariable int id, @Valid@RequestBody Blog blog)
   {


             blogService.updateBlog(blog,id);
           return ResponseEntity.status(200).body("Blog Updated");


   }


    @DeleteMapping("/{blogid}")
    public  ResponseEntity deleteBlog(@PathVariable int blogid, @AuthenticationPrincipal User myUser)
    {

        blogService.removeBlog(myUser.getId(),blogid);
        return ResponseEntity.status(200).body("Blog Deleted");

    }

    /*
    Get blog by Id
    Get blog by title*/





}
