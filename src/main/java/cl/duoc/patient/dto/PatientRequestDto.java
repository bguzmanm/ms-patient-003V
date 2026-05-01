package cl.duoc.patient.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PatientRequestDto {

    Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    String name;

    @NotBlank
    @Size(min = 1, max = 100)
    String lastName;

    @Email(message = "Email debe ser un email válido")
    @NotBlank(message = "Email no debe estar vacío")
    String email;

    @NotBlank
    String phone;
}
