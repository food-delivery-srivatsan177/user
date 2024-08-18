package com.srivatsan177.food_delivry.user.services;

import com.srivatsan177.food_delivry.user.dtos.AuthDTO;
import com.srivatsan177.food_delivry.user.dtos.LoginDTO;
import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface UserService {
    AuthDTO addUser(UserCreateDTO userCreateDTO) throws BadRequestException, NoSuchAlgorithmException;

    AuthDTO login(LoginDTO loginDTO) throws BadRequestException, NoSuchAlgorithmException;
}
