package com.luiz_matoso.e_commerce_payment_system.controller;

import com.luiz_matoso.e_commerce_payment_system.dto.UserRequest;
import com.luiz_matoso.e_commerce_payment_system.entities.User;
import com.luiz_matoso.e_commerce_payment_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest){
        User user = userRequest.convertDTO();
        User userSaved = userService.saveUser(user);

        return ResponseEntity.ok().body(userSaved);
    }

}
