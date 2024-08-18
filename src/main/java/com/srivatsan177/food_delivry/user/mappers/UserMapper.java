package com.srivatsan177.food_delivry.user.mappers;

import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.dtos.UserDTO;
import com.srivatsan177.food_delivry.user.models.User;

public class UserMapper {

    private UserMapper() {}

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .phoneNo(user.getPhoneNo())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .build();
    }

    public static User toUser(UserDTO user) {
        return User.builder()
                .id(user.getId())
                .phoneNo(user.getPhoneNo())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .build();
    }

    public static User toUser(UserCreateDTO user) {
        return User.builder()
                .id(user.getId())
                .phoneNo(user.getPhoneNo())
                .email(user.getEmail())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .build();
    }
}
