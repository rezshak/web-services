package reza.feedbackws.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static reza.feedbackws.dto.fixture.AddressDtoFixture.createAddressDto;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_CITY_LONG;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_CITY_SHORT;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE_LONG;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_LINE_SHORT;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_STATE_LONG;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_STATE_SHORT;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_ZIP_LONG;
import static reza.feedbackws.dto.fixture.FixtureConstants.ADDRESS_ZIP_SHORT;

public class AddressDtoValidationTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeEach
    public void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    public void tearDown() {
        validatorFactory.close();
    }

    @Test
    public void whenRequiredUse_isNull() {
        AddressDto dto = createAddressDto();
        dto.setUse(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Use is required");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "use");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredLine_isNull() {
        AddressDto dto = createAddressDto();
        dto.setLine(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Line is required", "Line cannot be blank");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(2, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredLine_isShort() {
        AddressDto dto = createAddressDto();
        dto.setLine(ADDRESS_LINE_SHORT);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Line must be 5-60 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredLine_isLong() {
        AddressDto dto = createAddressDto();
        dto.setLine(ADDRESS_LINE_LONG);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Line must be 5-60 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalLine2_isNull() {
        AddressDto dto = createAddressDto();
        dto.setLine2(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line2");
        });

        assertEquals(0, violations.size());
    }

    @Test
    public void whenOptionalLine2_isShort() {
        AddressDto dto = createAddressDto();
        dto.setLine2(ADDRESS_LINE_SHORT);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Line2 must be 5-60 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line2");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalLine2_isLong() {
        AddressDto dto = createAddressDto();
        dto.setLine2(ADDRESS_LINE_LONG);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Line2 must be 5-60 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "line2");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalCity_isNull() {
        AddressDto dto = createAddressDto();
        dto.setCity(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "city");
        });

        assertEquals(0, violations.size());
    }

    @Test
    public void whenOptionalCity_isShort() {
        AddressDto dto = createAddressDto();
        dto.setCity(ADDRESS_CITY_SHORT);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("City must be 3-30 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "city");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalCity_isLong() {
        AddressDto dto = createAddressDto();
        dto.setCity(ADDRESS_CITY_LONG);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("City must be 3-30 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "city");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalState_isNull() {
        AddressDto dto = createAddressDto();
        dto.setState(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "state");
        });

        assertEquals(0, violations.size());
    }

    @Test
    public void whenOptionalState_isShort() {
        AddressDto dto = createAddressDto();
        dto.setState(ADDRESS_STATE_SHORT);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("State must be 2 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "state");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalState_isLong() {
        AddressDto dto = createAddressDto();
        dto.setState(ADDRESS_STATE_LONG);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("State must be 2 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "state");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalZip_isNull() {
        AddressDto dto = createAddressDto();
        dto.setZip(null);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "zip");
        });

        assertEquals(0, violations.size());
    }

    @Test
    public void whenOptionalZip_isShort() {
        AddressDto dto = createAddressDto();
        dto.setZip(ADDRESS_ZIP_SHORT);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Zip must be 5-10 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "zip");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalZip_isLong() {
        AddressDto dto = createAddressDto();
        dto.setZip(ADDRESS_ZIP_LONG);

        Set<ConstraintViolation<AddressDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Zip must be 5-10 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "zip");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

}
