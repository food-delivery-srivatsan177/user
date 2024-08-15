package com.srivatsan177.food_delivry.user.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO {
    private String id;

    @NotNull
    private String phoneNo;

    @NotNull
    private String email;

    @NotNull(message = "first name is required field")
    private String firstName;

    private String lastName;

    private String middleName;

}
