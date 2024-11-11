package com.learn.security.controller;

import com.learn.security.entity.Users;
import com.learn.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> doRegister(@RequestBody Users users) {
        return new ResponseEntity<>(this.userService.registerUser(users), HttpStatus.OK);
    }

    @GetMapping("/placeOrder")
    public ResponseEntity<String> placeOrder() {
        return new ResponseEntity<>("Place Order triggered by GUEST", HttpStatus.OK);
    }

    @GetMapping("/payBill")
    public ResponseEntity<String> payBill() {
        return new ResponseEntity<>("Pay bil triggered by GUEST", HttpStatus.OK);
    }

    @GetMapping("/drinkWater")
    public ResponseEntity<String> drinkWater() {
        return new ResponseEntity<>("Drink water triggered by GUEST", HttpStatus.OK);
    }


}
