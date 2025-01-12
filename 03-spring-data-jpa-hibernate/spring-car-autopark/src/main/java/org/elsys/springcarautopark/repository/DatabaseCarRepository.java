package org.elsys.springcarautopark.repository;

import org.elsys.springcarautopark.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseCarRepository extends JpaRepository<Car,Long> {
  //ByBrand,byManufactureYear,byPriceBetween


}
