package com.example.demo.converter;

import com.example.demo.dto.SearchUserResponse;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toUser(UserRegisterRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public UserResponse toUserResponse(User savedUser){
        return new UserResponse(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail());
    }

    public SearchUserResponse toSearchUserResponse(User user){
        return new SearchUserResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getId(),
                user.getLastName());
    }


}
