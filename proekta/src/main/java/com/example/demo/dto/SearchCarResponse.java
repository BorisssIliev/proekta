package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchCarResponse extends CarResponse {

    public SearchCarResponse(Long id,String brand, String model, int seats, double pricePerDay) {
        super(id, brand, model, seats, pricePerDay);
    }

    public SearchCarResponse() {
    }
}
