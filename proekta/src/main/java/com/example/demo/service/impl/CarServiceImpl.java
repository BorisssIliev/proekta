package com.example.demo.service.impl;

import com.example.demo.converter.CarConverter;
import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.SearchCarResponse;
import com.example.demo.dto.UpdateCarRequest;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final CarConverter carConverter;

    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    @Override
    public CarResponse saveCar(CarRequest request) {
        Car car = carConverter.toCar(request);

        Car savedCar = carRepository.save(car);

        return carConverter.toCarResponse(savedCar);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public SearchCarResponse updateCar(Long id, UpdateCarRequest request) {
        Car car = carRepository.findById(id).orElseThrow();

        if (request.getBrand() != null &&!request.getBrand().isBlank()) {
            car.setBrand(request.getBrand());
        }
        if (request.getModel() != null &&!request.getModel().isBlank()) {
            car.setModel(request.getModel());
        }
        if (request.getSeats() != 0) {
            car.setSeats(request.getSeats());
        }
        if (request.getPricePerDay() != 0) {
            car.setPricePerDay(request.getPricePerDay());
        }
        return carConverter.toSearchCarResponse(carRepository.save(car));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
