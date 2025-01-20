package org.elsys.springcarautopark.car.repository;

import org.elsys.springcarautopark.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DatabaseCarRepository extends JpaRepository<Car,Long> {
  List<Car> findByBrand(String brand);
  List<Car> findByManufactureYear(int manufactureYear);
  List<Car> findByPriceBetween(double minPrice, double maxPrice);

  @Query("""
          SELECT c FROM Car c WHERE
            (:brand IS NULL OR c.brand LIKE %:brand%) AND 
            (:model IS NULL OR c.model LIKE %:model%) AND 
            (:year IS NULL OR c.manufactureYear = :year) AND 
            (:minPrice IS NULL OR c.price >= :minPrice) AND 
            (:maxPrice IS NULL OR c.price <= :maxPrice)
            """)
  List<Car> findCarsByFilters(@Param("brand") String brand,
                              @Param("model") String model,
                              @Param("year") Integer year,
                              @Param("minPrice") Double minPrice,
                              @Param("maxPrice") Double maxPrice);
}
