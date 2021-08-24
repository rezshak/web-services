package reza.feedbackws.model.constants;

public enum Use {

    MOBILE("mobile"),
    HOME("home"),
    WORK("work");

    private final String description;

    Use(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
