package reza.feedbackws.model;

import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

import static reza.feedbackws.dto.fixture.FixtureConstants.CONTACT_PHONE;

public final class ContactFixture {

    private ContactFixture() {
        // Prevent instantiation
    }

    public static Contact createContact() {
        return new Contact()
                .system(System.PHONE)
                .value(CONTACT_PHONE)
                .use(Use.HOME);
    }

}
