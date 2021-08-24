package reza.feedbackws.model;

import reza.feedbackws.model.constants.Use;

import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_CITY;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE2;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_STATE;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_ZIP;

public final class AddressFixture {

    private AddressFixture() {
        // Prevent instantiation
    }

    public static Address createAddress() {
        return new Address()
                .use(Use.MOBILE)
                .line(ADDRESS_LINE)
                .line2(ADDRESS_LINE2)
                .city(ADDRESS_CITY)
                .state(ADDRESS_STATE)
                .zip(ADDRESS_ZIP);
    }

}
