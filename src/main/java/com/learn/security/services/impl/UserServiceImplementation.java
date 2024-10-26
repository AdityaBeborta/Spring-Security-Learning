package com.learn.security.services.impl;

import com.learn.security.entity.Users;
import com.learn.security.repository.UserRepository;
import com.learn.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users registerUser(Users users) {
        users.setPassword(this.passwordEncoder.encode(users.getPassword()));
        return this.userRepository.save(users);
    }
}
