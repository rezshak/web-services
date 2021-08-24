package reza.feedbackws.dto.fixture;

import reza.feedbackws.dto.AddressDto;
import reza.feedbackws.model.constants.Use;

import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_CITY;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_ID;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE2;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_STATE;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_ZIP;

public final class AddressDtoFixture {

    private AddressDtoFixture() {
        // Prevent instantiation
    }

    public static AddressDto createAddressDto() {
        return new AddressDto()
                .id(ADDRESS_ID)
                .use(Use.MOBILE)
                .line(ADDRESS_LINE)
                .line2(ADDRESS_LINE2)
                .city(ADDRESS_CITY)
                .state(ADDRESS_STATE)
                .zip(ADDRESS_ZIP);
    }

}
