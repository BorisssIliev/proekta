package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationResponse {
    private Long id;
    private int days;
    //private String dateIn;
    //private String dateOut;
    private Long userId;
    private Long carId;
}
