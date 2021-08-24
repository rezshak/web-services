package reza.feedbackws.dto.fixture;

import java.util.List;
import reza.feedbackws.dto.FeedbackDto;
import reza.feedbackws.dto.PatientDto;
import reza.feedbackws.model.constants.Gender;

import static reza.feedbackws.dto.fixture.FeedbackDtoFixture.createFeedbackDtoList;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_BIRTH_DATE;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_FIRST_NAME;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_ID;
import static reza.feedbackws.dto.fixture.FixtureConstants.PATIENT_LAST_NAME;

public final class PatientDtoFixture {

    private PatientDtoFixture() {
        // Prevent instantiation
    }

    public static PatientDto createPatientDto() {
        return new PatientDto()
                .id(PATIENT_ID)
                .firstName(PATIENT_FIRST_NAME)
                .lastName(PATIENT_LAST_NAME)
                .birthDate(PATIENT_BIRTH_DATE)
                .gender(Gender.FEMALE);
    }

    public static PatientDto createPatientDtoWithFeedbacks() {
        List<FeedbackDto> feedbacks = createFeedbackDtoList();
        PatientDto dto = createPatientDto();
        dto.setFeedbacks(feedbacks);
        return dto;
    }

}
