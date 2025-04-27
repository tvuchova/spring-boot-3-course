package com.example.hospital.service.impl;

import com.example.hospital.controller.dto.DoctorDto;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.hospital.mapper.DoctorMapper.DOCTOR_MAPPER;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    @Override
    public List<DoctorDto> findAll() {
        return DOCTOR_MAPPER.toDoctorResources(doctorRepository.findAll());
    }

    @Override
    public DoctorDto findById(Long id) {
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.findById(id).orElse(null));
    }

    @Override
    public DoctorDto findByName(String name) {
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.findByName(name).get());
    }

    @Override
    public List<DoctorDto> findAllBySpecialization(String specialization) {
        return DOCTOR_MAPPER.toDoctorResources(doctorRepository.findAllBySpecialty(specialization));
    }

    @Override
    public boolean existsByName(String name) {
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.findByName(name).get()) != null;
    }

    @Override
    public DoctorDto save(DoctorDto doctorDto) {
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.save(DOCTOR_MAPPER.fromDoctorResource(doctorDto)));
    }

    @Override
    public DoctorDto update(DoctorDto doctorDto) {
        return DOCTOR_MAPPER.toDoctorResource(doctorRepository.save(DOCTOR_MAPPER.fromDoctorResource(doctorDto)));
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        doctorRepository.deleteAll();
    }
}
