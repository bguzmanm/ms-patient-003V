package cl.duoc.patient.service;

import cl.duoc.patient.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {
    PatientResponseDto findById(Long id);
    List<PatientResponseDto> findAll();
    PatientResponseDto create(PatientResponseDto patientResponseDto);
    PatientResponseDto update(PatientResponseDto patientResponseDto);
    boolean deleteById(Long id);
}
