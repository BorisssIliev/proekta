package com.example.demo.converter;

import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.SearchCarResponse;
import com.example.demo.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car toCar (CarRequest request){
        return Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .seats(request.getSeats())
                .pricePerDay(request.getPricePerDay())
                .build();
    }

    public CarResponse toCarResponse(Car savedCar){
        return new CarResponse(
                savedCar.getId(),
                savedCar.getBrand(),
                savedCar.getModel(),
                savedCar.getSeats(),
                savedCar.getPricePerDay());
    }

    public SearchCarResponse toSearchCarResponse(Car car){
        return new SearchCarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getSeats(),
                car.getPricePerDay());
    }
}
