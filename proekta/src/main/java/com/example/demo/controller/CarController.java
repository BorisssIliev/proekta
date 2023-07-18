package com.example.demo.controller;


import com.example.demo.dto.CarRequest;
import com.example.demo.dto.CarResponse;
import com.example.demo.dto.SearchCarResponse;
import com.example.demo.dto.UpdateCarRequest;
import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(path = "/register")
    public ResponseEntity<CarResponse> registerCar(@RequestBody CarRequest request) {
        CarResponse response = carService.saveCar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(carService.findById(id));
    }

    @PutMapping(path = "/updateCar/{id}")
    public ResponseEntity<SearchCarResponse> updateCar(@PathVariable Long id,
                                                       @RequestBody UpdateCarRequest request){
        SearchCarResponse carResponse = carService.updateCar(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(carResponse);
    }

    @DeleteMapping(path = "/deleteCar/{id}")
    public HttpStatus deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return HttpStatus.ACCEPTED;
    }

}