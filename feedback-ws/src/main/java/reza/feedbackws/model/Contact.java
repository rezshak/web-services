package reza.feedbackws.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

@Entity
@Table(name = "contacts")
public final class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "system", nullable = false)
    private System system;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "use", nullable = false)
    private Use use;

    public Contact() {
        // Keep me
    }

    public Contact system(System system) {
        this.system = system;
        return this;
    }

    public Contact value(String value) {
        this.value = value;
        return this;
    }

    public Contact use(Use use) {
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
