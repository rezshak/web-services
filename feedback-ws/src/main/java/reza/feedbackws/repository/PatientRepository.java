package reza.feedbackws.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reza.feedbackws.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

}
