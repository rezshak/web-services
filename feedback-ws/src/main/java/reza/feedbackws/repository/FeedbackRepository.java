package reza.feedbackws.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reza.feedbackws.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {

    List<Feedback> findByPatientId(UUID patientId);

}
