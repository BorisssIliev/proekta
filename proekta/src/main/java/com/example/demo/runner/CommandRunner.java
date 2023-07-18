package com.example.demo.runner;

import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    

    @Autowired
    CarRepository carRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        /*User user = User.builder()

                .firstName("Boris")
                .lastName("Iliev")
                .email("123@456")
                .password("1234567890")
                .build();

        userRepository.save(user);

        RentPlace rentPlace = RentPlace.builder()
                .placeName("Place For Cars")
                .build();

        rentPlaceRepository.save(rentPlace);


        Car BMW = Car.builder()
                .brand("BMV")
                .model("M1")
              .seats(5)
               .rentPlace(rentPlace)
                .price(500)
                .build();

        carRepository.save(BMW);


       Reservation reservation = Reservation.builder()
               .dateIn(Date.from(Instant.now()))
               .rentPlace(rentPlace)
               .days(2)
               .car(BMW)
               .user(user)
               .build();

        reservationRepository.save(reservation);
*/

    }
}