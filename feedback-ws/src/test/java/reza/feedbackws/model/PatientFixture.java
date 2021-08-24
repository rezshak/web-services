package reza.feedbackws.model;

import java.util.List;
import reza.feedbackws.model.constants.Gender;

import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_BIRTH_DATE;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_FIRST_NAME;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_LAST_NAME;
import static reza.feedbackws.model.FeedbackFixture.createFeedbackList;

public final class PatientFixture {

    private PatientFixture() {
        // Prevent instantiation
    }

    public static Patient createPatient() {
        return new Patient()
                .firstName(PATIENT_FIRST_NAME)
                .lastName(PATIENT_LAST_NAME)
                .birthDate(PATIENT_BIRTH_DATE)
                .gender(Gender.FEMALE);
    }

    public static Patient createPatientWithFeedbacks() {
        List<Feedback> feedbacks = createFeedbackList();
        Patient patient = createPatient();
        patient.setFeedbacks(feedbacks);
        return patient;
    }

}
