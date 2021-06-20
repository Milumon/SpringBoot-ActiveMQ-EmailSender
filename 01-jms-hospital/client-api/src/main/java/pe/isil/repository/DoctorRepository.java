package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
