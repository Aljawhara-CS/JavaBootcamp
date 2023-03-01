package com.example.drovemeds.Service;
import com.example.drovemeds.Exception.ApiException;
import com.example.drovemeds.Model.User;
import com.example.drovemeds.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {


     private  final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User myuser= userRepository.findUserByEmail(email);

        if (myuser==null)
        {
            throw new ApiException("Wrong email or password");
        }
       if (    myuser.getHospitalAdmin().getStatus().equals("Approved") )

        { return myuser;}


        throw new ApiException("User Not Approved Yet ");

    }

}
