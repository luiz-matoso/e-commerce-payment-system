package com.luiz_matoso.e_commerce_payment_system.services;

import com.luiz_matoso.e_commerce_payment_system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userDetails;
    }



}
