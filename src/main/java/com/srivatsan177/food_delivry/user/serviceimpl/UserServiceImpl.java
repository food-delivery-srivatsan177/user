package com.srivatsan177.food_delivry.user.serviceimpl;

import com.srivatsan177.food_delivry.user.dtos.AuthDTO;
import com.srivatsan177.food_delivry.user.dtos.LoginDTO;
import com.srivatsan177.food_delivry.user.dtos.UserCreateDTO;
import com.srivatsan177.food_delivry.user.mappers.UserMapper;
import com.srivatsan177.food_delivry.user.models.User;
import com.srivatsan177.food_delivry.user.repositories.UserRepository;
import com.srivatsan177.food_delivry.user.services.UserService;
import com.srivatsan177.food_delivry.user.utils.Auth;
import com.srivatsan177.food_delivry.user.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;


@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JWT jwt;

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
    public AuthDTO addUser(UserCreateDTO userCreateDTO) throws BadRequestException, NoSuchAlgorithmException {
        if (getUser(userCreateDTO.getPhoneNo(), userCreateDTO.getEmail()) != null) {
            throw new BadRequestException("Phone No or email is already registered");
        }
        userCreateDTO.setPassword(Auth.getMD5(userCreateDTO.getPassword()));
        User user = UserMapper.toUser(userCreateDTO);
        userRepository.save(user);

        return new AuthDTO(jwt.getJWT(user.getEmail()));
    }

    @Override
    public AuthDTO login(LoginDTO loginDTO) throws BadRequestException, NoSuchAlgorithmException {
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElse(null);
        if(user == null) {
            throw new BadRequestException(String.format("%s email does not exists in system", loginDTO.getEmail()));
        }
        if(!Auth.getMD5(loginDTO.getPassword()).equals(user.getPassword())) {
            throw new BadRequestException("Password is incorrect");
        }
        return new AuthDTO(jwt.getJWT(user.getEmail()));
    }
}
