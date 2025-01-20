package org.elsys.springcarautopark.car.model.dto;

import lombok.Data;

@Data
public class CarImagesDTO {
    private Long id;
    private String fileName;
    private String fileType;
    private String imageEncoded;
}
