package reza.feedbackws.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

public final class ContactUpdateDto {

    @Enumerated(EnumType.STRING)
    private System system;

    @NotBlank(message = "Value cannot be blank")
    @Size(min = 5, max = 30, message = "Value must be 5-30 characters")
    private String value;

    @Enumerated(EnumType.STRING)
    private Use use;

    public ContactUpdateDto() {
        // Keep me
    }

    public ContactUpdateDto system(System system) {
        this.system = system;
        return this;
    }

    public ContactUpdateDto value(String value) {
        this.value = value;
        return this;
    }

    public ContactUpdateDto use(Use use) {
        this.use = use;
        return this;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use use) {
        this.use = use;
    }

}
