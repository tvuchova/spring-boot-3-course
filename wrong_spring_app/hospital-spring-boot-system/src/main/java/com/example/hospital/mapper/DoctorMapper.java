package com.example.hospital.mapper;

import com.example.hospital.controller.dto.DoctorDto;
import com.example.hospital.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DoctorMapper {
    DoctorMapper DOCTOR_MAPPER = Mappers.getMapper(DoctorMapper.class);

    DoctorDto toDoctorResource(Doctor doctor);

    Doctor fromDoctorResource(DoctorDto doctorDto);

    List<DoctorDto> toDoctorResources(List<Doctor> doctors);

    List<Doctor> fromDoctorResources(List<DoctorDto> doctorDtos);
}
