package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    @Min(value = 3, message = "Name should contain at least 3 characters")
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
