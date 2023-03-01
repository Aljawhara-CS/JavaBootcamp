package com.example.drovemeds.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;//primary key


    //    @Pattern(regexp="(HospitalAdmin|CentralAdmin)")
    @Column(columnDefinition = "varchar(20)  null")
    @Pattern(regexp="(HospitalAdmin|CentralAdmin)")
    private String type_user;
    @Column(columnDefinition = "varchar(20) unique  not null")
    private String email;

    private String password;



    @OneToMany(cascade= CascadeType.ALL, mappedBy="user")
    private List<Request> requests;



    @OneToOne( cascade = CascadeType.ALL, mappedBy="user")
    @PrimaryKeyJoinColumn
    private HospitalAdmin hospitalAdmin;

    @OneToOne( cascade = CascadeType.ALL, mappedBy="user")
    @PrimaryKeyJoinColumn
    private CentralAdmin centralAdmin;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.type_user));

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

