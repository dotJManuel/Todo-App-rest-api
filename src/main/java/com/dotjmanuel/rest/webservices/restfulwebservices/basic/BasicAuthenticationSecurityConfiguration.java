package com.dotjmanuel.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
    
    //Filter chain
    //Authenticate all requests
    //Basic authentication
    //Disabling csrf
    //Stateless rest api
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return 
            http
                .authorizeHttpRequests(
                    auth -> 
                        auth
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated()
                    )
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                    session -> session.sessionCreationPolicy
                    (SessionCreationPolicy.STATELESS))
                .csrf().disable()
                .build();
    }
}
