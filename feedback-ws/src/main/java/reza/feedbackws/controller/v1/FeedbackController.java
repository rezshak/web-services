package reza.feedbackws.controller.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reza.feedbackws.dto.FeedbackDto;
import reza.feedbackws.dto.FeedbackUpdateDto;
import reza.feedbackws.model.Feedback;
import reza.feedbackws.repository.FeedbackRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/feedback")
@Validated
public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;

    @GetMapping("/")
    public ResponseEntity<List<Feedback>> listAllFeedbacks() {
        try {
            List<Feedback> feedbacks = new ArrayList<>(feedbackRepository.findAll());
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable UUID id) {
        Optional<Feedback> feedback = feedbackRepository.findById(id);

        if (feedback.isPresent()) {
            return new ResponseEntity<>(feedback.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Feedback> createFeedback(@RequestBody @Valid FeedbackDto request) {
        try {
            Feedback feedback = feedbackRepository.save(new Feedback()
                    .patientId(request.getPatientId())
                    .npi(request.getNpi())
                    .rating(request.getRating())
                    .comment(request.getComment()));
            return new ResponseEntity<>(feedback, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable UUID id, @RequestBody @Valid FeedbackUpdateDto request) {
        Optional<Feedback> existing = feedbackRepository.findById(id);

        if (existing.isPresent()) {
            Feedback update = existing.get();
            update.setRating(request.getRating());
            update.setComment(request.getComment());
            return new ResponseEntity<>(feedbackRepository.save(update), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteFeedbackById(@PathVariable UUID id) {
        try {
            feedbackRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllFeedbacks() {
        try {
            feedbackRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
