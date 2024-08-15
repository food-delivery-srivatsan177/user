package com.srivatsan177.food_delivry.user.controllers;

import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.dtos.UserDTO;
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

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserCreateDTO userCreateDTO) throws BadRequestException {
        return new ResponseEntity<>(userService.addUser(userCreateDTO), HttpStatus.OK);
    }
}

