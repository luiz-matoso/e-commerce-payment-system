package com.luiz_matoso.e_commerce_payment_system.services;

import com.luiz_matoso.e_commerce_payment_system.entities.User;
import com.luiz_matoso.e_commerce_payment_system.repositories.UserRepository;
import com.luiz_matoso.e_commerce_payment_system.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user){
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("This e-mail already exits.");
        } else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            String generateRandomCode = RandomString.generateRandomStrings(120);
            user.setAuthenticationCode(generateRandomCode);
            user.setEnabled(false);

            User savedUser = userRepository.save(user);
            return savedUser;
        }
    }

}
