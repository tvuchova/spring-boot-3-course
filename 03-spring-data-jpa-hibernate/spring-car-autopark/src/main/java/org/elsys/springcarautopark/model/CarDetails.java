package org.elsys.springcarautopark.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car_details")
public class CarDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String description;
    private String color;
    private Integer seatingCapacity;

    @Enumerated(EnumType.STRING)
    private FUEL_TYPE fuelType;

}
