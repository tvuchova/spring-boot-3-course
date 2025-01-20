package org.elsys.springcarautopark.rental.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToOne
   // @JoinColumn(name = "user_id", referencedColumnName = "id")
   // private User user;

  //  @ManyToOne
  //  @JoinColumn(name = "car_id", referencedColumnName = "id")
  //  private Car car;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private double price;

}

