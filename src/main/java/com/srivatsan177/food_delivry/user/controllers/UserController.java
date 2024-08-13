package com.srivatsan177.food_delivry.user.controllers;

import com.srivatsan177.food_delivry.user.dtos.UserDTO;
import com.srivatsan177.food_delivry.user.mappers.UserMapper;
import com.srivatsan177.food_delivry.user.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public UserDTO testing() {
        User user = new User(
                "123",
                "9137946954",
                "ksrivatsan177@gmail.com",
                "srivatsan",
                "iyengar",
                "kannan"
        );
        return UserMapper.toDTO(user);
    }
}
