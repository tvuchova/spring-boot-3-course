package org.elsys.springcarautopark.car.service;

import org.elsys.springcarautopark.exception.LimitMaxCarsException;
import org.elsys.springcarautopark.car.model.Car;
import org.elsys.springcarautopark.car.repository.DatabaseCarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();
    private final DatabaseCarRepository carRepository;

    @Value("${car.max-cars}")
    private int maxCars;

    public CarServiceImpl(DatabaseCarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void addCar(Car car) {
        if (cars.size() >= maxCars) {
            throw new LimitMaxCarsException("Автопаркът е пълен");
        }
        carRepository.save(car);
    }

    @Override
    public List<Car> searchByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    @Override
    public List<Car> searchByYear(int manufactureYear) {
       return carRepository.findByManufactureYear(manufactureYear);
    }

    @Override
    public List<Car> searchByRange(double minPrice, double maxPrice) {
        return carRepository.findByPriceBetween(minPrice, maxPrice);

    }
}
