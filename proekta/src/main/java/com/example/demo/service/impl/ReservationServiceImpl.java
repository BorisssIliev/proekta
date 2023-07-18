package com.example.demo.service.impl;

import com.example.demo.converter.ReservationConverter;
import com.example.demo.dto.ReservationRequest;
import com.example.demo.dto.ReservationResponse;
import com.example.demo.dto.SearchReservationResponse;
import com.example.demo.dto.UpdateReservationRequest;
import com.example.demo.entity.Car;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationConverter reservationConverter;

    private final CarRepository carRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationConverter reservationConverter, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationConverter = reservationConverter;
        this.carRepository = carRepository;
    }


    @Override
    public Reservation bookReservation(ReservationRequest request) {
        return reservationRepository.save(reservationConverter.toReservation(request));
    }

    @Override
    public ReservationResponse getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).get();
        return reservationConverter.toReservationResponse(reservation);
    }

    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
            return reservationRepository.findByUserId(userId);
    }

    @Override
    public List<Reservation> getReservationByCarId(Long carId) {
            return reservationRepository.findByCarId(carId);
    }

    @Override
    public SearchReservationResponse updateReservation(Long reservationId, Long carId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow();
        Car newCar = carRepository.findById(carId).orElseThrow();

        reservation.setCar(newCar);
        return reservationConverter.toSearchReservationResponse(reservationRepository.save(reservation));
    }


    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }


    //@Override
  //public Set<Reservation> getReservationsByIntervalWithNative(String dateIn, String dateOut) {
  //      return null;
  //  }

  //@Override
  //public List<User> getReservationByUser(String firstName, String LastName) {
  //    List<User> users = reservationRepository.findReservationByUser(firstName, LastName);
  //    return users;
  //}
}
