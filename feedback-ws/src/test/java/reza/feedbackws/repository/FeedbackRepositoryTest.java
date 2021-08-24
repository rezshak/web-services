package reza.feedbackws.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import reza.feedbackws.model.Feedback;

import static org.assertj.core.api.Assertions.assertThat;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_NPI1;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_ID;
import static reza.feedbackws.model.FeedbackFixture.createFeedback;

@DataJpaTest
class FeedbackRepositoryTest {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void empty() {
        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks).isEmpty();
    }

    @Test
    public void create() {
        Feedback feedback = createFeedback();
        Feedback created = feedbackRepository.save(feedback);

        assertThat(created).hasFieldOrProperty("id");
        assertThat(created).hasFieldOrPropertyWithValue("patientId", PATIENT_ID);
        assertThat(created).hasFieldOrPropertyWithValue("npi", FEEDBACK_NPI1);

        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks).hasSize(1);
    }

    @Test
    public void update() {
        Feedback feedback = createFeedback();
        feedback.setComment("Dr. Kelly is great");
        entityManager.persist(feedback);

        Feedback found = feedbackRepository.findById(feedback.getId()).get();
        feedback.setComment("I changed my mind, Dr. Kelly is not so good");
        feedbackRepository.save(found);

        Feedback updated = feedbackRepository.findById(feedback.getId()).get();
        assertThat(found.getComment()).isEqualTo(updated.getComment());
    }

    @Test
    public void findById() {
        Feedback feedback1 = createFeedback();
        Feedback feedback2 = createFeedback();
        Feedback feedback3 = createFeedback();

        entityManager.persist(feedback1);
        entityManager.persist(feedback2);
        entityManager.persist(feedback3);

        Feedback found = feedbackRepository.findById(feedback2.getId()).get();
        assertThat(found).isEqualTo(feedback2);

        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks).hasSize(3);
    }

    @Test
    public void deleteById() {
        Feedback feedback1 = createFeedback();
        Feedback feedback2 = createFeedback();
        Feedback feedback3 = createFeedback();

        entityManager.persist(feedback1);
        entityManager.persist(feedback2);
        entityManager.persist(feedback3);

        feedbackRepository.deleteById(feedback2.getId());

        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks).hasSize(2);
    }

    @Test
    public void deleteAll() {
        Feedback feedback1 = createFeedback();
        Feedback feedback2 = createFeedback();

        entityManager.persist(feedback1);
        entityManager.persist(feedback2);

        feedbackRepository.deleteAll();

        Iterable<Feedback> feedbacks = feedbackRepository.findAll();
        assertThat(feedbacks).isEmpty();
    }

}
