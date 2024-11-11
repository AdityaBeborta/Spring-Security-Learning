package com.learn.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menu")
public class AdminController {

    @GetMapping("/change")
    public ResponseEntity<String> changeMenu() {
        return new ResponseEntity<>("Change menu triggered by Admin", HttpStatus.OK);
    }
    @GetMapping("/updatePrice")
    public ResponseEntity<String> changePrice() {
        return new ResponseEntity<>("Change price triggered by Admin", HttpStatus.OK);
    }
}
