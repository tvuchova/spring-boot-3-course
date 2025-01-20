package org.elsys.springcarautopark.car.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private int manufactureYear;
    private int mileage;
    private double price;

    private CarDetailsDTO carDetails;
    private List<CarImagesDTO> carImages;
}
