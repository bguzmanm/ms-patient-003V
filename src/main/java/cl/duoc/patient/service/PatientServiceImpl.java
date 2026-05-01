package cl.duoc.patient.service;

import cl.duoc.patient.dto.HistoryPatientResponseDto;
import cl.duoc.patient.dto.PatientRequestDto;
import cl.duoc.patient.dto.PatientResponseDto;
import cl.duoc.patient.model.HistoryPatient;
import cl.duoc.patient.model.Patient;
import cl.duoc.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    private Patient toEntity(PatientResponseDto dto) {
        return new Patient(
                dto.getId(),
                dto.getName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone()
        );
    }

    private Patient toEntity(PatientRequestDto dto) {
        return new Patient(
                dto.getId(),
                dto.getName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhone()
        );
    }

    private PatientResponseDto toDto(Patient entity) {

        if (entity.getHistory() != null) {
            return new PatientResponseDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getLastName(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getHistory().stream().map(this::toDto).toList()
            );
        }

        return new PatientResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone()
        );

    }

    private HistoryPatientResponseDto toDto(HistoryPatient entity) {
        return new HistoryPatientResponseDto(
                entity.getId(),
                entity.getDescription(),
                entity.getCreatedAt()
                // toDto(entity.getPatient())
        );
    }

    @Override
    public PatientResponseDto findById(Long id) {
        return repository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public List<PatientResponseDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public PatientResponseDto create(PatientRequestDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public PatientResponseDto update(PatientRequestDto dto) {
        return toDto(repository.save(toEntity(dto)));
    }

    @Override
    public boolean deleteById(Long id) {
        if  (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
