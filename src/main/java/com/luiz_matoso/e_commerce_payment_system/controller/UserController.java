package com.luiz_matoso.e_commerce_payment_system.controller;

import com.luiz_matoso.e_commerce_payment_system.dto.UserRequest;
import com.luiz_matoso.e_commerce_payment_system.dto.UserResponse;
import com.luiz_matoso.e_commerce_payment_system.entities.User;
import com.luiz_matoso.e_commerce_payment_system.services.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody @Valid UserRequest userRequest) throws MessagingException, UnsupportedEncodingException {
        User user = userRequest.convertDTO();
        UserResponse userSaved = userService.saveUser(user);

        return ResponseEntity.ok().body(userSaved);
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code){
        if(userService.verify(code)){
            return "verify_success";
        } else {
            return "verify_failed";
        }
    }

}
