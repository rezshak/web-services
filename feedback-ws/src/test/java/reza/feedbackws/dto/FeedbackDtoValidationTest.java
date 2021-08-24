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
import static reza.feedbackws.dto.fixture.FeedbackDtoFixture.createFeedbackDto;

public class FeedbackDtoValidationTest {

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
    public void whenRequiredPatientId_isNull() {
        FeedbackDto dto = createFeedbackDto();
        dto.setPatientId(null);

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Patient ID is required");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "patientId");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredNpi_isNull() {
        FeedbackDto dto = createFeedbackDto();
        dto.setNpi(null);

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Npi cannot be blank", "Npi is required");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "npi");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(2, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredNpi_isBlank() {
        FeedbackDto dto = createFeedbackDto();
        dto.setNpi("");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Npi cannot be blank", "Npi must be 10 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "npi");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(2, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredNpi_isShort() {
        FeedbackDto dto = createFeedbackDto();
        dto.setNpi("123456789");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Npi must be 10 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "npi");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredNpi_isLong() {
        FeedbackDto dto = createFeedbackDto();
        dto.setNpi("12345678901");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Npi must be 10 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "npi");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredRating_isSmall() {
        FeedbackDto dto = createFeedbackDto();
        dto.setRating(0);

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Rating must be 1-10");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "rating");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenRequiredRating_isBig() {
        FeedbackDto dto = createFeedbackDto();
        dto.setRating(11);

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Rating must be 1-10");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "rating");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalComment_isBlank() {
        FeedbackDto dto = createFeedbackDto();
        dto.setComment("");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Comment cannot be blank", "Comment must be 10-120 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "comment");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(2, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalComment_isShort() {
        FeedbackDto dto = createFeedbackDto();
        dto.setComment("Abc");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Comment must be 10-120 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "comment");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

    @Test
    public void whenOptionalComment_isLong() {
        FeedbackDto dto = createFeedbackDto();
        dto.setComment("In these publications he demonstrated an attention to detail and thoroughness that became characteristic of his later work");

        Set<ConstraintViolation<FeedbackDto>> violations = validator.validate(dto);
        List<String> expectedViolationMessages = List.of("Comment must be 10-120 characters");
        List<String> actualViolationMessages = new ArrayList<>();

        violations.forEach(violation -> {
            assertEquals(violation.getPropertyPath().toString(), "comment");
            actualViolationMessages.add(violation.getMessage());
        });

        assertEquals(1, violations.size());
        assertTrue(actualViolationMessages.containsAll(expectedViolationMessages));
    }

}
