package com.example.hw17.Service;

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

    public  boolean updateUser(User user, Integer id) {


        User olduser = userRepository.getById(id);

        if (olduser==null)
        {  return false;}

     //   olduser.setId(user.getId());
        olduser.setRole(user.getRole());
        olduser.setName(user.getName());
        olduser.setEmail(user.getEmail());
        olduser.setAge(user.getAge());
        olduser.setPassword(user.getPassword());


        userRepository.save(olduser);
        return true;
    }

    public  boolean deleteUser(Integer id)
    {

    User olduser = userRepository.getById(id);

        if (olduser!=null)
        { userRepository.deleteById(id);
        return true;
        }
        return false;
    }






}
