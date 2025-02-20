package com.springproject.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {

public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {



    http
            .csrf(customizer -> customizer.disable())
            .authorizeHttpRequests(request-> request
                    .requestMatchers("register").permitAll()
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

return http.build();
}
@Autowired
public UserDetailsService userDetailsService ;

@Bean// DYNAMIC DB connection
public AuthenticationProvider authenticationProvider() {

    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    return  daoAuthenticationProvider;
}

//@Bean // manual
//public UserDetailsService userDetailsService(){
//
//     UserDetails user = User
//             .withDefaultPasswordEncoder()
//             .username("balaji")
//             .password("1234")
//             .build();
//
//
//     UserDetails admin = User
//             .withDefaultPasswordEncoder()
//             .username("ba")
//             .password("1234")
//             .build();
//    return new InMemoryUserDetailsManager(user,admin);
//    }


}


