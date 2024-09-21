package com.luiz_matoso.e_commerce_payment_system.repositories;

import com.luiz_matoso.e_commerce_payment_system.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByEmail(String email);
    User findByAuthenticationCode(String authenticationCode);
}
