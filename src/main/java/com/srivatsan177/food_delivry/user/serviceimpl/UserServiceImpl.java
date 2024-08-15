package com.srivatsan177.food_delivry.user.serviceimpl;

import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.dtos.UserDTO;
import com.srivatsan177.food_delivry.user.mappers.UserMapper;
import com.srivatsan177.food_delivry.user.models.User;
import com.srivatsan177.food_delivry.user.repositories.UserRepository;
import com.srivatsan177.food_delivry.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public User getUser(String phoneNo, String email) {
        return getUserByPhoneNo(phoneNo).orElseGet(() -> getUserByEmail(email).orElse(null));
    }

    public Optional<User> getUserByPhoneNo(String phoneNo) {
        return userRepository.findByPhoneNo(phoneNo);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDTO addUser(UserCreateDTO userCreateDTO) throws BadRequestException {
        if (getUser(userCreateDTO.getPhoneNo(), userCreateDTO.getEmail()) != null) {
            throw new BadRequestException("Phone No or email is already registered");
        }
        User user = UserMapper.toUser(userCreateDTO);
        userRepository.save(user);

        return UserMapper.toDTO(user);
    }
}
