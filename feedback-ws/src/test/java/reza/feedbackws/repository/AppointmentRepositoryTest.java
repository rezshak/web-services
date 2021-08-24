package reza.feedbackws.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import reza.feedbackws.model.Appointment;

import static org.assertj.core.api.Assertions.assertThat;
import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_END_TIME;
import static reza.feedbackws.model.Appointment.Status.FINISHED;
import static reza.feedbackws.model.Appointment.Status.PENDING;
import static reza.feedbackws.model.Appointment.Status.SCHEDULED;
import static reza.feedbackws.model.AppointmentFixture.createAppointment;

@DataJpaTest
class AppointmentRepositoryTest {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void empty() {
        Iterable<Appointment> addresses = appointmentRepository.findAll();
        assertThat(addresses).isEmpty();
    }

    @Test
    public void create() {
        Appointment appointment = createAppointment();
        Appointment created = appointmentRepository.save(appointment);

        assertThat(created).hasFieldOrProperty("id");
        assertThat(created).hasFieldOrPropertyWithValue("status", FINISHED);
        assertThat(created).hasFieldOrPropertyWithValue("end", APPOINTMENT_END_TIME);

        Iterable<Appointment> addresses = appointmentRepository.findAll();
        assertThat(addresses).hasSize(1);
    }

    @Test
    public void update() {
        Appointment contact = createAppointment();
        contact.setStatus(SCHEDULED);
        entityManager.persist(contact);

        Appointment found = appointmentRepository.findById(contact.getId()).get();
        contact.setStatus(PENDING);
        appointmentRepository.save(found);

        Appointment updated = appointmentRepository.findById(contact.getId()).get();
        assertThat(found.getStatus()).isEqualTo(updated.getStatus());
    }

    @Test
    public void findById() {
        Appointment appointment1 = createAppointment();
        Appointment appointment2 = createAppointment();
        Appointment appointment3 = createAppointment();

        entityManager.persist(appointment1);
        entityManager.persist(appointment2);
        entityManager.persist(appointment3);

        Appointment found = appointmentRepository.findById(appointment2.getId()).get();
        assertThat(found).isEqualTo(appointment2);

        Iterable<Appointment> appointments = appointmentRepository.findAll();
        assertThat(appointments).hasSize(3);
    }

    @Test
    public void deleteById() {
        Appointment appointment1 = createAppointment();
        Appointment appointment2 = createAppointment();
        Appointment appointment3 = createAppointment();

        entityManager.persist(appointment1);
        entityManager.persist(appointment2);
        entityManager.persist(appointment3);

        appointmentRepository.deleteById(appointment2.getId());

        Iterable<Appointment> appointments = appointmentRepository.findAll();
        assertThat(appointments).hasSize(2);
    }

    @Test
    public void deleteAll() {
        Appointment appointment1 = createAppointment();
        Appointment appointment2 = createAppointment();

        entityManager.persist(appointment1);
        entityManager.persist(appointment2);

        appointmentRepository.deleteAll();

        Iterable<Appointment> appointments = appointmentRepository.findAll();
        assertThat(appointments).isEmpty();
    }

}
