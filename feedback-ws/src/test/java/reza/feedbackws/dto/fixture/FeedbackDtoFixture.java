package reza.feedbackws.dto.fixture;

import java.util.List;
import reza.feedbackws.dto.FeedbackDto;

import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_COMMENT1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_COMMENT2;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_ID1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_ID2;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_NPI1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_NPI2;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_RATING1;
import static reza.feedbackws.dto.fixture.FixtureConstants.FEEDBACK_RATING2;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_ID;

public final class FeedbackDtoFixture {

    private FeedbackDtoFixture() {
        // Prevent instantiation
    }

    public static FeedbackDto createFeedbackDto() {
        return new FeedbackDto()
                .id(FEEDBACK_ID1)
                .patientId(PATIENT_ID)
                .npi(FEEDBACK_NPI1)
                .rating(FEEDBACK_RATING1)
                .comment(FEEDBACK_COMMENT1);
    }

    public static List<FeedbackDto> createFeedbackDtoList() {

        FeedbackDto dto1 = createFeedbackDto();
        FeedbackDto dto2 = new FeedbackDto()
                .id(FEEDBACK_ID2)
                .patientId(PATIENT_ID)
                .npi(FEEDBACK_NPI2)
                .rating(FEEDBACK_RATING2)
                .comment(FEEDBACK_COMMENT2);

        return List.of(dto1, dto2);
    }

}
