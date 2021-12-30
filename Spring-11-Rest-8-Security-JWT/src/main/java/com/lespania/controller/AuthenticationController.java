package com.lespania.controller;

import com.lespania.annotation.DefaultExceptionMessage;
import com.lespania.entity.AuthenticationRequest;
import com.lespania.entity.ResponseWrapper;
import com.lespania.entity.User;
import com.lespania.exception.ServiceException;
import com.lespania.service.UserService;
import com.lespania.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    @DefaultExceptionMessage(defaultMessage = "Hey, bad credentials :(")
    @PostMapping("/authenticate")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest){

        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        User foundUser = userService.readByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        authenticationManager.authenticate(authenticationToken);

        String jwtToken = jwtUtil.generateToken(foundUser);

        return ResponseEntity.ok(new ResponseWrapper("Login Succesfull!",jwtToken));

    }

    @PostMapping("/create-user")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody User user) throws ServiceException {

        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(new ResponseWrapper("User has been created successfully",createdUser));

    }


}
