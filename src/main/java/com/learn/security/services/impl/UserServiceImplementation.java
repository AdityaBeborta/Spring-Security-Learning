package com.learn.security.services.impl;

import com.learn.security.entity.Role;
import com.learn.security.entity.Users;
import com.learn.security.repository.RoleRepository;
import com.learn.security.repository.UserRepository;
import com.learn.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Users registerUser(Users users) {
        Role role = this.roleRepository.findByRoleType("ROLE_GUEST").orElse(null);
        users.setRoles(Set.of(role));
        users.setUserId(UUID.randomUUID().toString());
        users.setPassword(this.passwordEncoder.encode(users.getPassword()));
        return this.userRepository.save(users);
    }
}
