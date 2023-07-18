package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {

    @NotBlank
    @Length(min = 3,message = "Brand should contain at least 3 characters")
    private String brand;

    @NotBlank
    @Length(min = 3,message = "Model should contain at least 3 characters")
    private String model;

    @NotBlank
    private int seats;

    @NotBlank
    private double pricePerDay;
}
