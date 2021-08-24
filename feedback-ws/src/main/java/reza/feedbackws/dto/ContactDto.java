package reza.feedbackws.dto;

import java.util.UUID;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

public final class ContactDto {

    private UUID id;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "System is required")
    private System system;

    @NotBlank(message = "Value cannot be blank")
    @NotNull(message = "Value is required")
    @Size(min = 5, max = 30, message = "Value must be 5-30 characters")
    private String value;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Use is required")
    private Use use;

    public ContactDto() {
        // Keep me
    }

    public ContactDto id(UUID id) {
        this.id = id;
        return this;
    }

    public ContactDto system(System system) {
        this.system = system;
        return this;
    }

    public ContactDto value(String value) {
        this.value = value;
        return this;
    }

    public ContactDto use(Use use) {
        this.use = use;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
