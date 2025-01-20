package org.elsys.springcarautopark.car.model;

import jakarta.persistence.Column;
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
@Table(name = "car_images")
public class CarImages {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    @Column(name="file_content", columnDefinition="BLOB")
    private byte[] data;

}
