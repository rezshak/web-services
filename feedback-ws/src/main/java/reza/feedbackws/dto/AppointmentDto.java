package reza.feedbackws.dto;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import reza.feedbackws.model.Appointment.Status;

public final class AppointmentDto {

    private UUID id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private ZonedDateTime start;

    private ZonedDateTime end;

    public AppointmentDto() {
        // Keep me
    }

    public AppointmentDto id(UUID id) {
        this.id = id;
        return this;
    }

    public AppointmentDto status(Status status) {
        this.status = status;
        return this;
    }

    public AppointmentDto start(ZonedDateTime start) {
        this.start = start;
        return this;
    }

    public AppointmentDto end(ZonedDateTime end) {
        this.end = end;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
