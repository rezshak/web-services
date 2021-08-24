package reza.feedbackws.dto;

import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public final class FeedbackDto {

    private UUID id;

    @NotNull(message = "Patient ID is required")
    private UUID patientId;

    @NotBlank(message = "Npi cannot be blank")
    @NotNull(message = "Npi is required")
    @Size(min = 10, max = 10, message = "Npi must be 10 characters")
    private String npi;

    @NotNull(message = "Rating is required")
    @Min(value = 1, message = "Rating must be 1-10")
    @Max(value = 10, message = "Rating must be 1-10")
    private int rating;

    @NotBlank(message = "Comment cannot be blank")
    @Size(min = 10, max = 120, message = "Comment must be 10-120 characters")
    private String comment;

    public FeedbackDto() {
        // Keep me
    }

    public FeedbackDto id(UUID id) {
        this.id = id;
        return this;
    }

    public FeedbackDto patientId(UUID patientId) {
        this.patientId = patientId;
        return this;
    }

    public FeedbackDto npi(String npi) {
        this.npi = npi;
        return this;
    }

    public FeedbackDto rating(int rating) {
        this.rating = rating;
        return this;
    }

    public FeedbackDto comment(String comment) {
        this.comment = comment;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
