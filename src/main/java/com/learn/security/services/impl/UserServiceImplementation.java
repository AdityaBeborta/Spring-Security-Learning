package com.learn.security.services.impl;
import com.learn.security.entity.Users;
import com.learn.security.repository.UserRepository;
import com.learn.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users registerUser(Users users) {
        users.setPassword(this.bCryptPasswordEncoder.encode(users.getPassword()));
        return this.userRepository.save(users);
    }
}
