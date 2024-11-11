package com.learn.security;

import com.learn.security.entity.Role;
import com.learn.security.entity.Users;
import com.learn.security.repository.RoleRepository;
import com.learn.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class SpringSecurityLearningApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearningApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role roleAdmin = this.roleRepository.findByRoleType("ROLE_ADMIN").orElse(null);
        Role roleGuest = this.roleRepository.findByRoleType("ROLE_GUEST").orElse(null);

        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setRoleType("ROLE_ADMIN");
            roleAdmin.setRoleId(UUID.randomUUID().toString());
            this.roleRepository.save(roleAdmin);
        }
        if (roleGuest == null) {
            roleGuest = new Role();
            roleGuest.setRoleType("ROLE_GUEST");
            roleGuest.setRoleId(UUID.randomUUID().toString());
            this.roleRepository.save(roleGuest);
        }
        Users user = this.userRepository.findByUsername("Pihu");
        if (user == null) {
            user = new Users();
            user.setUserId(UUID.randomUUID().toString());
            user.setUsername("Pihu");
            user.setPassword(this.passwordEncoder.encode("pihu@123"));
            user.setRoles(Set.of(roleAdmin, roleGuest));
            this.userRepository.save(user);
        }

    }
}
