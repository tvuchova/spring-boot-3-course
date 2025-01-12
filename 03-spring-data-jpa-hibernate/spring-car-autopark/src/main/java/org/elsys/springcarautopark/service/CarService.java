package org.elsys.springcarautopark.service;

import org.elsys.springcarautopark.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    void addCar(Car car);
    List<Car> searchByBrand(String brand);
    List<Car> searchByYear(int manufactureYear);
    List<Car> searchByRange(double minPrice, double maxPrice);
}
