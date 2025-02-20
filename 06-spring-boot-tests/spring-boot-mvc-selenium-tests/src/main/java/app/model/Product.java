package app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 4, max = 20)
    private String name;

    @Positive
    private Double quantity;

    @NotBlank
    @Size(min = 1, max = 5)
    private String unit;

    @Positive
    private Double price;

    @NotBlank
    @Size(min = 1, max = 5)
    private String currency;

    @NotNull
    private Date expirationDate;

}
