package reza.feedbackws.dto;

import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import reza.feedbackws.model.constants.Gender;

public final class PatientUpdateDto {

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 3, max = 30, message = "First name must be 3-30 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 3, max = 30, message = "First name must be 3-30 characters")
    private String lastName;

    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PatientUpdateDto() {
        // Keep me
    }

    public PatientUpdateDto firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PatientUpdateDto lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PatientUpdateDto birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PatientUpdateDto gender(Gender gender) {
        this.gender = gender;
        return this;
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

}
