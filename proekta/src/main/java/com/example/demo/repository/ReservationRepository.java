package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM reservations WHERE date_in between ?1 and ?2 AND date_out between ?1 and ?2")
    Optional<Set<Reservation>> getReservationsByIntervalWithNative(String dateIn, String dateOut);

    List<Reservation> findByUserId(Long userId);

    List<Reservation> findByCarId(Long carId);
}
