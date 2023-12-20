package com.spacetokens.spacetokensapp.controllers;

import com.spacetokens.spacetokensapp.entities.User;
import com.spacetokens.spacetokensapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/userCreation")
    public ResponseEntity<User> createNewUser(){
        User user = userService.createUser();
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
