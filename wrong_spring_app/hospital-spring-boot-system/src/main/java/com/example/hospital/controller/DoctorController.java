package com.example.hospital.controller;

import com.example.hospital.controller.dto.DoctorDto;
import com.example.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/hospital/doctor")
@RequiredArgsConstructor
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.save(doctorDto));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.update(doctorDto));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteById(@RequestBody Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<?> deleteAll() {
        doctorService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestBody Long id) {
        return ResponseEntity.ok(doctorService.findById(id));
    }

    @GetMapping("/findByName")
    public ResponseEntity<?> findByName(@RequestBody String name) {
        return ResponseEntity.ok(doctorService.findByName(name));
    }

    @GetMapping("/findAllBySpecialization")
    public ResponseEntity<?> findAllBySpecialization(@RequestBody String specialization) {
        return ResponseEntity.ok(doctorService.findAllBySpecialization(specialization));
    }

    @GetMapping("/existsByName")
    public ResponseEntity<?> existsByName(@RequestBody String name) {
        return ResponseEntity.ok(doctorService.existsByName(name));
    }
}
