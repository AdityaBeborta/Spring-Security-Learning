package com.learn.security.repository;

import com.learn.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,String> {

    Users findByUsername(String username);
}
