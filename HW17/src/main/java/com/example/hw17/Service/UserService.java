package com.example.hw17.Service;

import com.example.hw17.Exception.ApiException;
import com.example.hw17.Repostry.UserRepository;
import com.example.hw17.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUser()
    {
        return userRepository.findAll();
    }

    public  void addUser(User user) {

        userRepository.save(user);

    }

    public  void updateUser(User user, Integer id) {


        User olduser = userRepository.findUserbyId(id);

        if (olduser==null)
        {          throw new ApiException(" User not found");
        }

     //   olduser.setId(user.getId());
        olduser.setRole(user.getRole());
        olduser.setName(user.getName());
        olduser.setEmail(user.getEmail());
        olduser.setAge(user.getAge());
        olduser.setPassword(user.getPassword());


        userRepository.save(olduser);
    }

    public  void deleteUser(Integer id)
    {

    User olduser = userRepository.findUserbyId(id);

        if (olduser!=null)
        {
            userRepository.deleteById(id);
        //return true;

        }
        //return false;

        throw new ApiException(" User not found");

    }

    public List<User>  findUserByRole( String role)
    {
        List<User>  user= userRepository.findUserByRole(role);
        if(user==null)
        {
            throw new ApiException(" User not found");
        }

        return user;

    }

    public User findUserByEmail( String email)
    {
        User user= userRepository.findUserByEmail(email);
        if(user==null)
        {
            throw new ApiException(" User not found");
        }

        return user;

    }

   public List<User> findUsersByAge( Integer age)
    {
        List<User> user= userRepository.findUsersByAge(age);
        if(user==null)
        {
            throw new ApiException(" User not found");
        }

        return user;

    }

    public User findUsersByUsernameAndPassword( String username, String password )
    {
        User user= userRepository.findUsersByUsernameAndPassword(username,password);
        if(user==null)
        {
            throw new ApiException(" Password or Username not correct!");
        }

        return user;

    }






}
