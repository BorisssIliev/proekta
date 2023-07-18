package com.example.demo.service;

import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.SearchCarResponse;
import com.example.demo.dto.UpdateCarRequest;
import com.example.demo.entity.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    CarResponse saveCar(CarRequest request);
    abstract Car findById(Long id);
    SearchCarResponse updateCar(Long id, UpdateCarRequest request);
    void deleteCar(Long id);
}
