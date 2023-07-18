package com.example.demo.controller;


import com.example.demo.dto.SearchUserResponse;
import com.example.demo.dto.UpdateUserRequest;
import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Register user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponse.class)) }),
            @ApiResponse(responseCode = "409", description = "User with email already used",
                    content = @Content) })
    @PostMapping(path = "/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
        UserResponse response = userService.saveUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(id));
    }

    @GetMapping(path = "/email")
    public ResponseEntity<List<User>> getUserByEmail(@RequestParam String email){
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserByEmail(email));
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping(path = "/updateUser/{id}")
    public ResponseEntity<SearchUserResponse> updateUser(@PathVariable Long id ,
                                                         @RequestBody UpdateUserRequest request){
        SearchUserResponse userResponse = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PutMapping(path = "/updatePass/{id}") //За да видите промяната в паролата си отворете таблицата users в workbench
    public ResponseEntity<SearchUserResponse> updatePass(@PathVariable Long id,
                                                         @RequestBody UpdateUserRequest request){
        SearchUserResponse userResponse = userService.updatePass(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
