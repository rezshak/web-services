package reza.feedbackws.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import reza.feedbackws.model.constants.Gender;

public final class PatientDto {

    private UUID id;

    @NotBlank(message = "First name cannot be blank")
    @NotNull(message = "First name is required")
    @Size(min = 3, max = 30, message = "First name must be 3-30 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NotNull(message = "Last name is required")
    @Size(min = 3, max = 30, message = "First name must be 3-30 characters")
    private String lastName;

    @NotNull(message = "First name is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Gender is required")
    private Gender gender;

    private List<FeedbackDto> feedbacks = new ArrayList<>();

    public PatientDto() {
        // Keep me
    }

    public PatientDto id(UUID id) {
        this.id = id;
        return this;
    }

    public PatientDto firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientDto lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientDto birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PatientDto gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public PatientDto feedbacks(List<FeedbackDto> feedbacks) {
        this.feedbacks = feedbacks;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<FeedbackDto> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackDto> feedbacks) {
        this.feedbacks = feedbacks;
    }

}
