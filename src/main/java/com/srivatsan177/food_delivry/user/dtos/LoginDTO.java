package com.srivatsan177.food_delivry.user.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {
    @NotNull(message = "email is a required field")
    private String email;

    @NotNull(message = "password is a required field")
    private String password;
}
