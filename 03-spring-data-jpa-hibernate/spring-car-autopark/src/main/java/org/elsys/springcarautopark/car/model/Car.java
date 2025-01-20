package org.elsys.springcarautopark.car.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int manufactureYear;
    private int mileage;
    private double price;

}
