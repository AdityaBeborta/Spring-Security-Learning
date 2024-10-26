package com.learn.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiController {

    //endpoint one
    @GetMapping("/route1")
    public String route1() {
        return "This is for protected route 1 ";
    }

    //endpoint two
    @GetMapping("/route2")
    public String route2() {
        return "This is for protected route 2";
    }
}
