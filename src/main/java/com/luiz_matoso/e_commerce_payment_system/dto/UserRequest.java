package com.luiz_matoso.e_commerce_payment_system.dto;

import com.luiz_matoso.e_commerce_payment_system.entities.User;

public record UserRequest(String firstName, String lastName, String email, String password) {

    public User convertDTO(){
        return new User(firstName,lastName,email,password);
    }

}
