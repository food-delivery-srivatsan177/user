package com.srivatsan177.food_delivry.user.controllers;

import com.srivatsan177.food_delivry.user.dtos.AuthDTO;
import com.srivatsan177.food_delivry.user.dtos.LoginDTO;
import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<AuthDTO> addUser(@RequestBody @Valid UserCreateDTO userCreateDTO) throws BadRequestException, NoSuchAlgorithmException {
        return new ResponseEntity<>(userService.addUser(userCreateDTO), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody @Valid LoginDTO loginDTO) throws BadRequestException, NoSuchAlgorithmException {
        return new ResponseEntity<>(userService.login(loginDTO), HttpStatus.OK);
    }
}

