package cl.duoc.patient.controller;

import cl.duoc.patient.dto.PatientRequestDto;
import cl.duoc.patient.dto.PatientResponseDto;
import cl.duoc.patient.model.Patient;
import cl.duoc.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> findAll() {
        logger.info("ejecutando un findAll de Pacientes");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDto> findById(@PathVariable Long id) {
        try {
            PatientResponseDto patient = service.findById(id);
            if (patient == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(service.findById(id));

        } catch (Exception e ) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> create(@Valid @RequestBody PatientRequestDto dto) {
        PatientResponseDto createdPatient = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

}
