package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.SearchUserResponse;
import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
    @Override
    public UserResponse saveUser(UserRegisterRequest request) {

        User user = userConverter.toUser(request);

        User savedUser = userRepository.save(user);

        return userConverter.toUserResponse(savedUser);

    }

    @Override
    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).get();

        return userConverter.toUserResponse(user);

    }
    @Override
    public List<User> getUserByEmail(String email) {
       List<User> users = userRepository.findByEmail(email);

       return users;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public SearchUserResponse updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id).orElseThrow();



        if (request.getFirstName() != null &&!request.getFirstName().isBlank()) {
            user.setFirstName(request.getFirstName());
        }
        if ( request.getLastName() != null && !request.getLastName().isBlank()) {
            user.setLastName(request.getLastName());
        }
        if ( request.getEmail() != null && !request.getEmail().isBlank()) {
            user.setEmail(request.getEmail());
        }

        return userConverter.toSearchUserResponse(userRepository.save(user));

    }


    @Override
    public SearchUserResponse updatePass(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        if (request.getPassword() != null &&!request.getPassword().isBlank()) {
            user.setPassword(request.getPassword());
        }
        return userConverter.toSearchUserResponse(userRepository.save(user));
    }
}
