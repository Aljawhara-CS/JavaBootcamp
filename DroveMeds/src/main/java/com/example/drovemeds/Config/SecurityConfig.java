package com.example.drovemeds.Config;


import com.example.drovemeds.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final MyUserDetailsService myUserDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);

        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;

    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())

                .authorizeHttpRequests()
                .requestMatchers("/api/v1/user/register",
                        "/api/v1/user/registerCentralAdmin",
                        "/api/v1/user/login").permitAll()

                .requestMatchers("/api/v1/hospital/CentralAdmin/**",
                                            "/api/v1/user/CentralAdmin/**",
                                             "/api/v1/medicine/CentralAdmin/**",
                                            "/api/v1/request/CentralAdmin/**",
                                            "/api/v1/user/CentralAdmin/**")
                .hasAuthority("CentralAdmin")

                .requestMatchers("/api/v1/detail/HospitalAdmin/**",
                                          "/api/v1/request/HospitalAdmin/**",
                                          "/api/v1/patient/HospitalAdmin/**")
                .hasAuthority("HospitalAdmin")

                .requestMatchers("/api/v1/user/get","/api/v1/hospital/get",
                        "/api/v1/patient/get",  "/api/v1/detail/get","/api/v1/request/get",
                        "/api/v1/medicine/get")
                .hasAnyAuthority("HospitalAdmin","CentralAdmin")
                .anyRequest().authenticated()

                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)

                .and()
                .httpBasic();
        return http.build();




    }

}
