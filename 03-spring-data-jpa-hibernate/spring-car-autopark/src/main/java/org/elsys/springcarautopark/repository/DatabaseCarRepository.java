package org.elsys.springcarautopark.repository;

import org.elsys.springcarautopark.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseCarRepository extends JpaRepository<Car,Long> {
  List<Car> findByBrand(String brand);
  List<Car> findByManufactureYear(int manufactureYear);
  List<Car> findByPriceBetween(double minPrice, double maxPrice);


}
