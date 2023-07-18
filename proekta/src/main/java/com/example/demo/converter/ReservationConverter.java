package com.example.demo.converter;

import com.example.demo.dto.ReservationRequest;
import com.example.demo.dto.ReservationResponse;
import com.example.demo.dto.SearchReservationResponse;
import com.example.demo.entity.Car;
import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Component
public class ReservationConverter {

    @Autowired
    CarService carService;

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;

    public Reservation toReservation(ReservationRequest request) {
        Car car = carService.findById(request.getCarId());
        Reservation reservation = Reservation.builder()
                .user(getUser(request.getUserId()))
                .car(car)
                //.dateIn(request.getDateIn())
                //.dateOut(getDateOut(request.getDays(), request.getDateIn()))
                .price(request.getDays() * car.getPricePerDay())
                .days(request.getDays())
                .build();

        return reservation;
    }

    public ReservationResponse toReservationResponse (Reservation reservation){
        return ReservationResponse.builder()
                .userId(reservation.getUser().getId())
                .carId(reservation.getCar().getId())
                .days(reservation.getDays())
                //.dateIn(reservation.getDateIn().toString())
                //.dateOut(reservation.getDateOut().toString())
                .id(reservation.getId())
                .build();
    }

    public SearchReservationResponse toSearchReservationResponse (Reservation reservation){
        return new SearchReservationResponse(
                reservation.getUser().getId(),
                reservation.getDays(),
                //reservation.getDateIn(),
                //reservation.getDateOut(),
                reservation.getCar().getId(),
                reservation.getId());
    }

    User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    Car getCar(Long id){
        return carRepository.findById(id).orElseThrow();
    }

    Instant getDateOut(int stays, Instant dateIn) {
        return dateIn.plusMillis
                (TimeUnit.MILLISECONDS.convert(stays, TimeUnit.DAYS));
    }
}

