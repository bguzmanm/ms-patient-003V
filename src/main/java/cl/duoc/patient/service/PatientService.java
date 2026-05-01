package cl.duoc.patient.service;

import cl.duoc.patient.dto.PatientRequestDto;
import cl.duoc.patient.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {
    PatientResponseDto findById(Long id);
    List<PatientResponseDto> findAll();
    PatientResponseDto create(PatientRequestDto dto);
    PatientResponseDto update(PatientRequestDto dto);
    boolean deleteById(Long id);
}
