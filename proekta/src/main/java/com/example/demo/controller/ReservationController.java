package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping(path = "/register")
    public ResponseEntity<Reservation> registerReservation(@RequestBody ReservationRequest request){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.bookReservation(request));

    }

    @GetMapping(path = "/findByReservationId/{id}")
    public ResponseEntity<ReservationResponse> getReservation(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(reservationService.getReservationById(id));
    }

   @GetMapping(path = "/findByUserId/{userId}")
   public ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Long userId) {
       List<Reservation> reservations = reservationService.getReservationsByUserId(userId);
       return ResponseEntity.status(HttpStatus.FOUND).body(reservationService.getReservationsByUserId(userId));
   }

   @GetMapping(path = "/findByCarId/{carId}")
    public ResponseEntity<List<Reservation>> getReservationByCarId(@PathVariable Long carId){
        List<Reservation> reservations = reservationService.getReservationByCarId(carId);
        return  ResponseEntity.status(HttpStatus.FOUND).body(reservationService.getReservationByCarId(carId));
   }

   @DeleteMapping(path = "/deleteReservation/{id}")
    public HttpStatus deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return HttpStatus.ACCEPTED;
   }

   @PutMapping(path = "/updateReservation/{reservationId}/changeCar/{carId}")
    public ResponseEntity<SearchReservationResponse> updateReservation(@PathVariable Long reservationId,
                                                                       @PathVariable Long carId){
       SearchReservationResponse reservationResponse = reservationService.updateReservation(reservationId, carId);
       return ResponseEntity.status(HttpStatus.OK).body(reservationResponse);
   }

}
