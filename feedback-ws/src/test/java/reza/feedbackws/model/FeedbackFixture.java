package reza.feedbackws.model;

import java.util.List;

import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_COMMENT1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_COMMENT2;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_NPI1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_NPI2;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_RATING1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_RATING2;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_ID;

public final class FeedbackFixture {

    private FeedbackFixture() {
        // Prevent instantiation
    }

    public static Feedback createFeedback() {
        return new Feedback()
                .patientId(PATIENT_ID)
                .npi(FEEDBACK_NPI1)
                .rating(FEEDBACK_RATING1)
                .comment(FEEDBACK_COMMENT1);
    }

    public static List<Feedback> createFeedbackList() {

        Feedback f1 = createFeedback();
        Feedback f2 = new Feedback()
                .patientId(PATIENT_ID)
                .npi(FEEDBACK_NPI2)
                .rating(FEEDBACK_RATING2)
                .comment(FEEDBACK_COMMENT2);

        return List.of(f1, f2);
    }

}
