package reza.feedbackws.dto.fixture;

import reza.feedbackws.dto.ContactDto;
import reza.feedbackws.model.constants.System;
import reza.feedbackws.model.constants.Use;

import static reza.feedbackws.dto.fixture.FixtureConstants.CONTACT_ID;
import static reza.feedbackws.dto.fixture.FixtureConstants.CONTACT_PHONE;

public final class ContactDtoFixture {

    private ContactDtoFixture() {
        // Prevent instantiation
    }

    public static ContactDto createContactDto() {
        return new ContactDto()
                .id(CONTACT_ID)
                .system(System.PHONE)
                .value(CONTACT_PHONE)
                .use(Use.HOME);
    }

}
