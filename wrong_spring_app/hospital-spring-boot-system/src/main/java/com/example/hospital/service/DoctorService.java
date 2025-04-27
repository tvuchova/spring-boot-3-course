package com.example.hospital.service;

import com.example.hospital.controller.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> findAll();
    DoctorDto findById(Long id);
    DoctorDto findByName(String name);
    List<DoctorDto> findAllBySpecialization(String specialization);
    boolean existsByName(String name);
    DoctorDto save(DoctorDto doctorDto);
    DoctorDto update(DoctorDto doctorDto);
    void deleteById(Long id);
    void deleteAll();
}
