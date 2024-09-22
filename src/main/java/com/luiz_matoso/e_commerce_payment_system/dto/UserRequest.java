package com.luiz_matoso.e_commerce_payment_system.dto;

import com.luiz_matoso.e_commerce_payment_system.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @NotNull(message = "First name cannot be null.")
        @NotBlank(message = "First name cannot be empty.")
        String firstName,

        @NotNull(message = "Last name cannot be null.")
        @NotBlank(message = "Last name cannot be empty.")
        String lastName,

        @NotNull(message = "E-mail cannot be null.")
        @NotBlank(message = "E-mail cannot be empty.")
        String email,

        @NotNull(message = "Password cannot be null.")
        @NotBlank(message = "Password cannot be empty.")
        @Size(min = 8, message = "Password must be minimum 8 characters.")
        String password,

        @NotNull(message = "User role cannot be null.")
        @NotBlank(message = "User role cannot be empty.")
        String userRole) {

    public User convertDTO(){
        return new User(firstName,lastName,email,password, userRole);
    }

}
