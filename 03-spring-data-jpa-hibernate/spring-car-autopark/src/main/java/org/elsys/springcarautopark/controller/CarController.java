package org.elsys.springcarautopark.controller;

import org.elsys.springcarautopark.exception.LimitMaxCarsException;
import org.elsys.springcarautopark.model.Car;
import org.elsys.springcarautopark.service.CarService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody Car car) {

        carService.addCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body("Car added successfully");
    }

    @GetMapping
    public List<Car> getCar(){
        return carService.getAll();
    }

    @GetMapping("/brand")
    public List<Car> findCarsByBrand(@RequestParam String brand) {
        return carService.searchByBrand(brand);
    }

    @GetMapping("/year")
    public List<Car> findCarsByYear(@RequestParam int year) {
        return carService.searchByYear(year);
    }

    @GetMapping("/price-range")
    public List<Car> findCarsByMaxPrice(@RequestParam double maxPrice,
                                        @RequestParam double minPrice) {
        return carService.searchByRange(minPrice, maxPrice);
    }
}
