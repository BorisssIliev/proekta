package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class SearchReservationResponse extends ReservationResponse{
    public SearchReservationResponse(Long userId, int days, Long carId, Long reservationId) {
        super(reservationId, days, userId ,carId );
    }

    public SearchReservationResponse() {
    }
}
