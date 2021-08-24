package reza.feedbackws.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public final class FeedbackUpdateDto {

    @Min(value = 1, message = "Rating must be 1-10")
    @Max(value = 10, message = "Rating must be 1-10")
    private Long rating;

    @NotBlank(message = "Npi cannot be blank")
    @Size(min = 10, max = 120, message = "Line must be 10-120 characters")
    private String comment;

    public FeedbackUpdateDto() {
        // Keep me
    }

    public FeedbackUpdateDto rating(long rating) {
        this.rating = rating;
        return this;
    }

    public FeedbackUpdateDto comment(String comment) {
        this.comment = comment;
        return this;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
