package com.learn.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SpringSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

//    @Bean
//    //overriding the default security filter chain
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(Customizer -> Customizer.disable());
//        httpSecurity.httpBasic();
//        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
////        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return httpSecurity.build();
//    }

    //we are saying not to read user details from application properties but from in memory
    //with this code we cannot achieve the authentication from DB, so we will need to comment this code
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("Sriya").password("s@123").build();
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("Aditya").password("a@123").build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    //    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        return daoAuthenticationProvider;
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
