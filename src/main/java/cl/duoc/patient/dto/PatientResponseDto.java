package cl.duoc.patient.dto;

import cl.duoc.patient.model.HistoryPatient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PatientResponseDto {

    public PatientResponseDto(Long id, String name, String lastName, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @NotNull
    Long id;

    @NotBlank
    String name;
    @NotBlank
    String lastName;
    @Email
    String email;
    @NotBlank
    String phone;

    List<HistoryPatientResponseDto> history;
}
