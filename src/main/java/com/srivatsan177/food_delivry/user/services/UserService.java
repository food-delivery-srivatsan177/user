package com.srivatsan177.food_delivry.user.services;

import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.dtos.UserDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO addUser(UserCreateDTO userCreateDTO) throws BadRequestException;
}
