package com.example.demo.dto;


import com.example.demo.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
public class SearchUserResponse extends UserResponse {

    public SearchUserResponse(String firstName, String lastName, long id, String email ) {
        super(id, firstName, lastName,email);
    }

    public SearchUserResponse(){

    }
}
