package com.example.javabootcamphw28.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data

public class Customer implements UserDetails {

   // id - username - password - role(CUSTOMER-ADMIN) (Add All Required Validation)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Pattern(regexp="(CUSTOMER|ADMIN)")
    private String role;

   // Customer - Request (One to Many)

    @OneToMany(cascade= CascadeType.ALL, mappedBy="customer")
    private List<Request> requests;


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
