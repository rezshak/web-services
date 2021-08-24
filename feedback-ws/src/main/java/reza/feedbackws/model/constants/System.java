package reza.feedbackws.model.constants;

public enum System {

    EMAIL("email"),
    PHONE("phone");

    private final String description;

    System(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
