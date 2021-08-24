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
import static reza.feedbackws.dto.fixture.ContactDtoFixture.createContactDto;
import static reza.feedbackws.dto.fixture.FixtureConstants.CONTACT_VALUE_LONG;
import static reza.feedbackws.dto.fixture.FixtureConstants.CONTACT_VALUE_SHORT;

public class ContactDtoValidationTest {

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
    public void whenRequiredSystem_isNull() {
        ContactDto dto = createContactDto();
        dto.setSystem(null);

        Set<ConstraintViolation<ContactDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("System is required");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "system");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredValue_isNull() {
        ContactDto dto = createContactDto();
        dto.setValue(null);

        Set<ConstraintViolation<ContactDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Value is required", "Value cannot be blank");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "value");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(2, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredValue_isShort() {
        ContactDto dto = createContactDto();
        dto.setValue(CONTACT_VALUE_SHORT);

        Set<ConstraintViolation<ContactDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Value must be 5-30 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "value");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredValue_isLong() {
        ContactDto dto = createContactDto();
        dto.setValue(CONTACT_VALUE_LONG);

        Set<ConstraintViolation<ContactDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Value must be 5-30 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "value");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredUse_isNull() {
        ContactDto dto = createContactDto();
        dto.setUse(null);

        Set<ConstraintViolation<ContactDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Use is required");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "use");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

}
