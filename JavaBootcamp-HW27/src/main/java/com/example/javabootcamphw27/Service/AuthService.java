package com.example.javabootcamphw27.Service;


import com.example.javabootcamphw27.Exception.ApiException;
import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Model.User;
import com.example.javabootcamphw27.Repostry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;


    public void register(User myUser) {
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        userRepository.save(myUser);
    }

  /*  public void addBlogForUser (Blog blog, int userId)
    {

        User user=userRepository.findUsersById(userId);
        if(user==null)
        {
            throw  new ApiException(" not found");
        }

        user.setBlogs(blog);


    }*/







}
