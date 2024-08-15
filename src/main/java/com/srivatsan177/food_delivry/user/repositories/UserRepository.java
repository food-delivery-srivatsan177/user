package com.srivatsan177.food_delivry.user.repositories;

import com.srivatsan177.food_delivry.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Override
    @NonNull
    List<User> findAll();

    Optional<User> findByPhoneNo(String phoneNo);

    Optional<User> findByEmail(String email);
}
