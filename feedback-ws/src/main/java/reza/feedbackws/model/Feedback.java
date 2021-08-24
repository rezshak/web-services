package reza.feedbackws.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public final class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;

    @Column(name = "npi", nullable = false)
    private String npi;

    @Column(name = "rating", nullable = false)
    private long rating;

    @Column(name = "comment")
    private String comment;

    public Feedback() {
        // Keep me
    }

    public Feedback patientId(UUID patientId) {
        this.patientId = patientId;
        return this;
    }

    public Feedback npi(String npi) {
        this.npi = npi;
        return this;
    }

    public Feedback rating(long rating) {
        this.rating = rating;
        return this;
    }

    public Feedback comment(String comment) {
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

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
