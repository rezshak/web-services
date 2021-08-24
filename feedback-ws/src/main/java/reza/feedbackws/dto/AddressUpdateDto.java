package reza.feedbackws.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import reza.feedbackws.model.constants.Use;

public final class AddressUpdateDto {

    @Enumerated(EnumType.STRING)
    private Use use;

    @Size(min = 5, max = 60, message = "Line must be 5-60 characters")
    private String line;

    @Size(min = 5, max = 60, message = "Line2 must be 5-60 characters")
    private String line2;

    @Size(min = 3, max = 30, message = "City must be 3-30 characters")
    private String city;

    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String state;

    @Size(min = 5, max = 10, message = "Zip must be 5-10 characters")
    private String zip;

    public AddressUpdateDto() {
        // Keep me
    }

    public AddressUpdateDto use(Use use) {
        this.use = use;
        return this;
    }

    public AddressUpdateDto line(String line) {
        this.line = line;
        return this;
    }

    public AddressUpdateDto line2(String line2) {
        this.line2 = line2;
        return this;
    }

    public AddressUpdateDto city(String city) {
        this.city = city;
        return this;
    }

    public AddressUpdateDto state(String state) {
        this.state = state;
        return this;
    }

    public AddressUpdateDto zip(String zip) {
        this.zip = zip;
        return this;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use use) {
        this.use = use;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
