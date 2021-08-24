package reza.feedbackws.dto;

import java.time.ZonedDateTime;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import reza.feedbackws.model.Appointment.Status;

public final class AppointmentUpdateDto {

    @Enumerated(EnumType.STRING)
    private Status status;

    private ZonedDateTime start;

    private ZonedDateTime end;

    public AppointmentUpdateDto() {
        // Keep me
    }

    public AppointmentUpdateDto status(Status status) {
        this.status = status;
        return this;
    }

    public AppointmentUpdateDto start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public AppointmentUpdateDto end(ZonedDateTime end) {
        this.end = end;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public void setStart(ZonedDateTime start) {
        this.start = start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public void setEnd(ZonedDateTime end) {
        this.end = end;
    }

}
