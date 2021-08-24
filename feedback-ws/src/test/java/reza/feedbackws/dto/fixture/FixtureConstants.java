package reza.feedbackws.dto.fixture;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public abstract class FixtureConstants {

    // Patient
    public static final UUID PATIENT_ID = UUID.fromString("911b49fe-dcf5-457d-b6ed-f7999bb5ff67");
    public static final String PATIENT_FIRST_NAME = "Barbra";
    public static final String PATIENT_LAST_NAME = "Zimmerman";
    public static final LocalDate PATIENT_BIRTH_DATE = LocalDate.now().minusYears(55);

    // Feedback
    public final static UUID FEEDBACK_ID1 = UUID.fromString("01105935-a86c-42bd-897f-c7521f4cf863");
    public final static String FEEDBACK_NPI1 = "1245319588";
    public final static int FEEDBACK_RATING1 = 8;
    public final static String FEEDBACK_COMMENT1 = "Dr. Kelly was very attentive";

    public final static UUID FEEDBACK_ID2 = UUID.fromString("4b93bb99-dc14-4882-8ae3-a3f6a2452af0");
    public final static String FEEDBACK_NPI2 = "1245319599";
    public final static int FEEDBACK_RATING2 = 2;
    public final static String FEEDBACK_COMMENT2 = "Dr. Gibson was unable to provide a diagnosis";

    // Contact
    public final static UUID CONTACT_ID = UUID.fromString("f90db69f-ccef-46da-aa2b-d13c2ce9f605");
    public final static String CONTACT_PHONE = "808-742-8609";

    public final static String CONTACT_VALUE_SHORT = "8zR";
    public final static String CONTACT_VALUE_LONG = "X36ix9mJ4ujvVx9osAbTeAKh9Np7akU";

    // Address
    public final static UUID ADDRESS_ID = UUID.fromString("b81c9ad5-e3eb-46ca-8f36-b77cd9e25497");
    public static final String ADDRESS_LINE = "1395 Juniper Drive";
    public static final String ADDRESS_LINE2 = "Unit 123";
    public final static String ADDRESS_CITY = "Grand Rapids";
    public final static String ADDRESS_STATE = "MI";
    public final static String ADDRESS_ZIP = "49503";

    public final static String ADDRESS_LINE_SHORT = "1 Ab";
    public final static String ADDRESS_LINE_LONG = "FYcn68y7WL7uiRwGLgv33jrFh8GAkijT632KyagV8QJqfHjNDR8hyZipxrF2S";
    public final static String ADDRESS_CITY_SHORT = "1a";
    public final static String ADDRESS_CITY_LONG = "Qz4Qo7bhj5XewnqEMckbkM38hUNrhci";
    public final static String ADDRESS_STATE_SHORT = "H";
    public final static String ADDRESS_STATE_LONG = "HAB";
    public final static String ADDRESS_ZIP_SHORT = "1234";
    public final static String ADDRESS_ZIP_LONG = "12345-12345";

    // Appointment
    public final static UUID APPOINTMENT_ID = UUID.fromString("f7dbe098-1cb9-4472-8f7e-f4d9dd651148");
    public final static ZonedDateTime APPOINTMENT_START_TIME = ZonedDateTime.now().minusHours(3);
    public final static ZonedDateTime APPOINTMENT_END_TIME = ZonedDateTime.now().minusHours(1);

}
