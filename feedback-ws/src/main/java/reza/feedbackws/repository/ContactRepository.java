package reza.feedbackws.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reza.feedbackws.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

}
