package com.example.javabootcamphw27.Service;

import com.example.javabootcamphw27.Model.User;
import com.example.javabootcamphw27.Repostry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User myUser=userRepository.findUsersByUsername(username);
        if(myUser==null){
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return myUser;
    }





}
