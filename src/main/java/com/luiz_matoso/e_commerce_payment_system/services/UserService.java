package com.luiz_matoso.e_commerce_payment_system.services;

import com.luiz_matoso.e_commerce_payment_system.dto.UserResponse;
import com.luiz_matoso.e_commerce_payment_system.entities.User;
import com.luiz_matoso.e_commerce_payment_system.repositories.UserRepository;
import com.luiz_matoso.e_commerce_payment_system.util.RandomString;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    public UserResponse saveUser(User user) throws MessagingException, UnsupportedEncodingException {
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("This e-mail already exits.");
        } else{
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            String generateRandomCode = RandomString.generateRandomStrings(64);
            user.setAuthenticationCode(generateRandomCode);
            user.setEnabled(false);

            User savedUser = userRepository.save(user);

            UserResponse userResponse = new UserResponse(
                    savedUser.getId(),
                    savedUser.getFirstName(),
                    savedUser.getLastName(),
                    savedUser.getEmail(),
                    savedUser.getPassword());

            mailService.sendEmailVerification(user);
            return userResponse;
        }
    }

    public boolean verify(String authenticationCode){
        User user = userRepository.findByAuthenticationCode(authenticationCode);
        if (user == null || user.isEnabled()){
            return false;
        } else{

            user.setAuthenticationCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }
    }

}
