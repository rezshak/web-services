package reza.feedbackws.repository;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import reza.feedbackws.model.Patient;

import static org.assertj.core.api.Assertions.assertThat;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_BIRTH_DATE;
import static reza.feedbackws.model.PatientFixture.createPatient;

@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void empty() {
        Iterable<Patient> patients = patientRepository.findAll();
        assertThat(patients).isEmpty();
    }

    @Test
    public void create() {
        Patient patient = createPatient();
        Patient created = patientRepository.save(patient);

        assertThat(created).hasFieldOrProperty("id");
        assertThat(created).hasFieldOrPropertyWithValue("birthDate", PATIENT_BIRTH_DATE);

        Iterable<Patient> patients = patientRepository.findAll();
        assertThat(patients).hasSize(1);
    }

    @Test
    public void update() {
        Patient patient = createPatient();
        patient.setBirthDate(LocalDate.now().minusYears(40));
        entityManager.persist(patient);

        Patient found = patientRepository.findById(patient.getId()).get();
        patient.setBirthDate(LocalDate.now().minusYears(33));
        patientRepository.save(found);

        Patient updated = patientRepository.findById(patient.getId()).get();
        assertThat(patient.getBirthDate()).isEqualTo(updated.getBirthDate());
    }

    @Test
    public void findById() {
        Patient patient1 = createPatient();
        Patient patient2 = createPatient();
        Patient patient3 = createPatient();

        entityManager.persist(patient1);
        entityManager.persist(patient2);
        entityManager.persist(patient3);

        Patient found = patientRepository.findById(patient2.getId()).get();
        assertThat(found).isEqualTo(patient2);

        Iterable<Patient> appointments = patientRepository.findAll();
        assertThat(appointments).hasSize(3);
    }

    @Test
    public void deleteById() {
        Patient patient1 = createPatient();
        Patient patient2 = createPatient();
        Patient patient3 = createPatient();

        entityManager.persist(patient1);
        entityManager.persist(patient2);
        entityManager.persist(patient3);

        patientRepository.deleteById(patient2.getId());

        Iterable<Patient> patients = patientRepository.findAll();
        assertThat(patients).hasSize(2);
    }

    @Test
    public void deleteAll() {
        Patient patient1 = createPatient();
        Patient patient2 = createPatient();

        entityManager.persist(patient1);
        entityManager.persist(patient2);

        patientRepository.deleteAll();

        Iterable<Patient> patients = patientRepository.findAll();
        assertThat(patients).isEmpty();
    }

}
