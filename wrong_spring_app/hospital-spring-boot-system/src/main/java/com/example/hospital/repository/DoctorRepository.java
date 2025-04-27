package com.example.hospital.repository;

import com.example.hospital.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByName(String name);
    List<Doctor> findAllBySpecialty(String specialty);
    void deleteAll();

}
