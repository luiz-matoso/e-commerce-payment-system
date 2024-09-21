package com.luiz_matoso.e_commerce_payment_system.dto;

import java.util.UUID;

public record UserResponse(UUID id, String firstName, String lastName, String email, String password) {
}
