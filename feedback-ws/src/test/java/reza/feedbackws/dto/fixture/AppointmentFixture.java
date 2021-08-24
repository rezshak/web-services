package reza.feedbackws.dto.fixture;

import reza.feedbackws.dto.AppointmentDto;

import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_END_TIME;
import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_ID;
import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_START_TIME;
import static reza.feedbackws.model.Appointment.Status.FINISHED;

public final class AppointmentFixture {

    private AppointmentFixture() {
        // Prevent instantiation
    }

    public static AppointmentDto createAppointmentDto() {
        return new AppointmentDto()
                .id(APPOINTMENT_ID)
                .status(FINISHED)
                .start(APPOINTMENT_START_TIME)
                .end(APPOINTMENT_END_TIME);
    }

}
