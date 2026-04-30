package cl.duoc.patient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Setter @Getter @NoArgsConstructor
public class Patient {

    public Patient(Long id, String name, String lastName, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Column(name = "last_name")
    String lastName;
    String email;
    String phone;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    List<HistoryPatient> history;

}
