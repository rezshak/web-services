package reza.feedbackws.model;

import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_END_TIME;
import static reza.feedbackws.dto.fixture.FixtureConstants.APPOINTMENT_START_TIME;
import static reza.feedbackws.model.Appointment.Status.FINISHED;

public final class AppointmentFixture {

    public AppointmentFixture() {
        // Prevent instantiation
    }

    public static Appointment createAppointment() {
        return new Appointment()
                .status(FINISHED)
                .start(APPOINTMENT_START_TIME)
                .end(APPOINTMENT_END_TIME);
    }

}
