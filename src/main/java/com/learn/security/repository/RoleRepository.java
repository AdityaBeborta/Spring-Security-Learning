package com.learn.security.repository;

import com.learn.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByRoleType(String roleType);
}
