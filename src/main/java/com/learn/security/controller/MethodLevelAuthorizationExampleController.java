package com.learn.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methodLevelAuthorization")
public class MethodLevelAuthorizationExampleController {

    @PreAuthorize("hasRole('GUEST')")
    @GetMapping("/guest")
    public String methodLevelAuthorizationGuest() {
        return "Guest Authorized";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String methodLevelAuthorizationAdmin() {
        return "Admin Authorized";
    }
}
