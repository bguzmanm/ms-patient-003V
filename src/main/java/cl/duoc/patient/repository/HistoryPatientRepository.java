package cl.duoc.patient.repository;

import cl.duoc.patient.model.HistoryPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryPatientRepository extends JpaRepository<HistoryPatient, Long> {
}
