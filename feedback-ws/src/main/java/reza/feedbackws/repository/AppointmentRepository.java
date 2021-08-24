package reza.feedbackws.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reza.feedbackws.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

}
