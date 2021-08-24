package reza.feedbackws.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import reza.feedbackws.model.Contact;
import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

import static org.assertj.core.api.Assertions.assertThat;
import static reza.feedbackws.model.ContactFixture.createContact;

@DataJpaTest
class ContactRepositoryTest {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void empty() {
        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).isEmpty();
    }

    @Test
    public void create() {
        Contact contact = createContact();
        Contact created = contactRepository.save(contact);

        assertThat(created).hasFieldOrProperty("id");
        assertThat(created).hasFieldOrPropertyWithValue("system", System.PHONE);

        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(1);
    }

    @Test
    public void update() {
        Contact contact = createContact();
        contact.setUse(Use.HOME);
        entityManager.persist(contact);

        Contact found = contactRepository.findById(contact.getId()).get();
        found.setUse(Use.WORK);
        contactRepository.save(found);

        Contact updated = contactRepository.findById(contact.getId()).get();
        assertThat(found.getUse()).isEqualTo(updated.getUse());
    }

    @Test
    public void findById() {
        Contact contact1 = createContact();
        Contact contact2 = createContact();
        Contact contact3 = createContact();

        entityManager.persist(contact1);
        entityManager.persist(contact2);
        entityManager.persist(contact3);

        Contact found = contactRepository.findById(contact2.getId()).get();
        assertThat(found).isEqualTo(contact2);

        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(3);
    }

    @Test
    public void deleteById() {
        Contact contact1 = createContact();
        Contact contact2 = createContact();
        Contact contact3 = createContact();

        entityManager.persist(contact1);
        entityManager.persist(contact2);
        entityManager.persist(contact3);

        contactRepository.deleteById(contact2.getId());

        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).hasSize(2);
    }

    @Test
    public void deleteAll() {
        Contact contact1 = createContact();
        Contact contact2 = createContact();

        entityManager.persist(contact1);
        entityManager.persist(contact2);

        contactRepository.deleteAll();

        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).isEmpty();
    }

}
