package com.example.demo.service;

import com.example.demo.dto.SearchUserResponse;
import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    UserResponse saveUser(UserRegisterRequest request);

    List<User> getUserByEmail(String email);
    UserResponse getUser(Long id);

    void deleteUser(Long id);

    SearchUserResponse updateUser(Long id, UpdateUserRequest request);

    SearchUserResponse updatePass(Long id, UpdateUserRequest request);
}
