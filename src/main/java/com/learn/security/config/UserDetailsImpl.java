package com.learn.security.config;

import com.learn.security.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private final Users users;

    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = this.users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleType())).collect(Collectors.toSet());
        return roles;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }
}
