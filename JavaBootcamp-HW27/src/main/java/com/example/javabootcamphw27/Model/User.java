package com.example.javabootcamphw27.Model;


import com.example.javabootcamphw27.Service.MyUserDetailsService;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User implements UserDetails {
/*    User Class:
    id - username - password (Add All validation required)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(unique = true)
    private String username;

    private  String password;

  /*  One to Many Relation:
    User - Blog*/

    @OneToMany(cascade= CascadeType.ALL, mappedBy="user")
    private List<Blog> blogs;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
