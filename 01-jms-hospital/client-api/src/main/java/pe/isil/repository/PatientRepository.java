package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.isil.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
