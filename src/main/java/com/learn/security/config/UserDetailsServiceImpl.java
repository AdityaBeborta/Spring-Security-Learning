package com.learn.security.config;

import com.learn.security.config.UserDetailsImpl;
import com.learn.security.entity.Users;
import com.learn.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

@Autowired
private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users byUsername = this.userRepository.findByUsername(username);
        if(byUsername ==null){
            throw new UsernameNotFoundException("user doesn't exist");
        }
        return new UserDetailsImpl(byUsername);
    }
}
