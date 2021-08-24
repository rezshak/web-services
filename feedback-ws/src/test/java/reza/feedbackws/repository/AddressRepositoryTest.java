package reza.feedbackws.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import reza.feedbackws.model.Address;
import reza.feedbackws.model.constants.Use;

import static org.assertj.core.api.Assertions.assertThat;
import static reza.feedbackws.model.AddressFixture.createAddress;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void empty() {
        Iterable<Address> addresses = addressRepository.findAll();
        assertThat(addresses).isEmpty();
    }

    @Test
    public void create() {
        Address address = createAddress();
        Address created = addressRepository.save(address);

        assertThat(created).hasFieldOrProperty("id");
        assertThat(created).hasFieldOrPropertyWithValue("use", Use.MOBILE);

        Iterable<Address> addresses = addressRepository.findAll();
        assertThat(addresses).hasSize(1);
    }

    @Test
    public void update() {
        Address address = createAddress();
        address.setUse(Use.HOME);
        entityManager.persist(address);

        Address found = addressRepository.findById(address.getId()).get();
        found.setUse(Use.WORK);
        addressRepository.save(found);

        Address updated = addressRepository.findById(address.getId()).get();
        assertThat(found.getUse()).isEqualTo(updated.getUse());
    }

    @Test
    public void findById() {
        Address address1 = createAddress();
        Address address2 = createAddress();
        Address address3 = createAddress();

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(address3);

        Address found = addressRepository.findById(address2.getId()).get();
        assertThat(found).isEqualTo(address2);

        Iterable<Address> addresses = addressRepository.findAll();
        assertThat(addresses).hasSize(3);
    }

    @Test
    public void deleteById() {
        Address address1 = createAddress();
        Address address2 = createAddress();
        Address address3 = createAddress();

        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.persist(address3);

        addressRepository.deleteById(address2.getId());

        Iterable<Address> addresses = addressRepository.findAll();
        assertThat(addresses).hasSize(2);
    }

}
