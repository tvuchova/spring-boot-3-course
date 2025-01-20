package org.elsys.springcarautopark.rental.controller;

import lombok.AllArgsConstructor;
import org.elsys.springcarautopark.car.model.Car;
import org.elsys.springcarautopark.car.service.CarService;

import org.elsys.springcarautopark.rental.model.Rental;
import org.elsys.springcarautopark.rental.model.RentalStatus;
import org.elsys.springcarautopark.rental.model.dto.RentalDto;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/rentals")
public class RentalController {

    @PostMapping
    public Rental createRental(@RequestBody RentalDto rentalDto) {

       //TODO: implement this
        return null;
    }

    @PatchMapping("/{rentalId}/status")
    public Rental updateRentalStatus(@PathVariable Long rentalId, @RequestParam RentalStatus status) {
      //TODO: implement this
        return null;
    }

}
