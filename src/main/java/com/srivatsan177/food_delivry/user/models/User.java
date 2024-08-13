package com.srivatsan177.food_delivry.user.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String phoneNo;

    @Indexed(unique = true)
    private String email;

    private String firstName;

    private String lastName;

    private String middleName;
}
