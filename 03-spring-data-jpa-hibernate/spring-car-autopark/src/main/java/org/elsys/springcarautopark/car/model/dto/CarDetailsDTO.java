package org.elsys.springcarautopark.car.model.dto;

import lombok.Data;
import org.elsys.springcarautopark.car.model.FUEL_TYPE;

@Data
public class CarDetailsDTO {
    private String description;
    private String color;
    private Integer seatingCapacity;
    private FUEL_TYPE fuelType;
}
