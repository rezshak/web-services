package reza.feedbackws.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import reza.feedbackws.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
