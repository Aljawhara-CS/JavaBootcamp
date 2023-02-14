package com.example.javabootcamphw27.Service;

import com.example.javabootcamphw27.Exception.ApiException;
import com.example.javabootcamphw27.Model.User;
import com.example.javabootcamphw27.Repostry.BlogRepository;
import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Repostry.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class BlogService {

/*
    Get blog by Id
    Get blog by title*/
    private  final BlogRepository blogRepository;
    private  final UserRepository userRepository;

    private final AuthService authService;





    public List<Blog> getBlog() {

        return blogRepository.findAll();
    }
    public  void addBlog(Blog blog, int userId) {

        User user = userRepository.findUsersById(userId);
        if(user==null)
        {
            throw  new ApiException(" not found");
        }

        blog.setUser(user);
        blogRepository.save(blog);
      //  authService.addBlogForUser(blog,userId);


    }

    public  void updateBlog(Blog blog, int id) {

    Blog blog1= blogRepository.findBlogById(id);
    if (blog1==null)
    {}

    blog1.setTitle(blog.getTitle());
    blog1.setBody(blog.getBody());
        blogRepository.save(blog1);
        // still need the user !

    }

    public void removeBlog(Integer userId, Integer blogId) {
        Blog blog=blogRepository.findById(blogId).get();

        if(blog.getUser().getId()!=userId){
            return;
        }

        blogRepository.deleteById(blogId);
    }

//Get All user blogs
    public List<Blog> getUserBlogs(Integer id)
    {
        return blogRepository.findAllByUserId(id);
    }

//    Get blog by Id

    public Blog getBlogById (Integer blogId)
    {
        Blog blog = blogRepository.findBlogById(blogId);
        return blog;

    }

    //Get blog by title

    public Blog getBlogByTitle (String title)
    {
        Blog blog = blogRepository.findBlogByTitle(title);
        return blog;

    }






}
