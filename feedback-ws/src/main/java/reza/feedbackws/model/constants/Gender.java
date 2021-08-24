package reza.feedbackws.model.constants;

public enum Gender {

    FEMALE("female"),
    MALE("male"),
    OTHER("other");

    private final String description;

    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "description='" + description + '\'' +
                '}';
    }

}
