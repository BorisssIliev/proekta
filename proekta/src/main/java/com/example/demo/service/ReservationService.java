package com.example.demo.service;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.dto.ReservationResponse;
import com.example.demo.dto.SearchReservationResponse;
import com.example.demo.dto.UpdateReservationRequest;
import com.example.demo.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    Reservation bookReservation(ReservationRequest request);
    ReservationResponse getReservationById(Long id);

    List<Reservation> getReservationsByUserId(Long userId);

    List<Reservation> getReservationByCarId(Long carId);

    SearchReservationResponse updateReservation(Long reservationId, Long carId);

    void deleteReservation(Long id);



    // Set<Reservation> getReservationsByIntervalWithNative(String dateIn, String dateOut);
    //List<User> getReservationByUser(String firstName, String LastName);

}
