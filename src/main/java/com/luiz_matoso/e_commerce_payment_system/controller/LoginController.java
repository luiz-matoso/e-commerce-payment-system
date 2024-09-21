package com.luiz_matoso.e_commerce_payment_system.controller;


import com.luiz_matoso.e_commerce_payment_system.dto.AuthenticationRequest;
import com.luiz_matoso.e_commerce_payment_system.dto.AuthenticationResponse;
import com.luiz_matoso.e_commerce_payment_system.entities.User;
import com.luiz_matoso.e_commerce_payment_system.services.TokenService;
import com.luiz_matoso.e_commerce_payment_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest){
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authenticationRequest.email(),
                authenticationRequest.password()
        );
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponse(token));

    }
}
