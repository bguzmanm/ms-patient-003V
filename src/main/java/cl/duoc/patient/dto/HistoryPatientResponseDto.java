package cl.duoc.patient.dto;

import cl.duoc.patient.model.Patient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HistoryPatientResponseDto {
    @NotNull
    Long id;
    @NotBlank
    String description;
    Date createdAt;
    // @NotNull
    PatientResponseDto patient;

    public HistoryPatientResponseDto(Long id, String description, Date createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }
}
