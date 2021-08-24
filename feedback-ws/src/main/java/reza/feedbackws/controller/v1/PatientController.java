package reza.feedbackws.controller.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.persistence.EntityManager;
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
import reza.feedbackws.dto.PatientDto;
import reza.feedbackws.dto.PatientUpdateDto;
import reza.feedbackws.model.Feedback;
import reza.feedbackws.model.Patient;
import reza.feedbackws.repository.FeedbackRepository;
import reza.feedbackws.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/patient")
@Validated
public class PatientController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/{id}/feedback")
    public ResponseEntity<List<Feedback>> getPatientFeedbacks(@PathVariable UUID id) {
        List<Feedback> feedbacks = feedbackRepository.findByPatientId(id);

        if (!feedbacks.isEmpty()) {
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Patient>> listAllPatients() {
        try {
            List<Patient> patients = new ArrayList<>(patientRepository.findAll());

            for (Patient p : patients) {
                List<Feedback> feedbacks = feedbackRepository.findByPatientId(p.getId());
                p.setFeedbacks(feedbacks);
            }

            return new ResponseEntity<>(patients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable UUID id) {
        Optional<Patient> patient = patientRepository.findById(id);

        if (patient.isPresent()) {
            List<Feedback> feedbacks = feedbackRepository.findByPatientId(patient.get().getId());
            patient.get().setFeedbacks(feedbacks);
            return new ResponseEntity<>(patient.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Patient> createPatient(@RequestBody @Valid PatientDto request) {
        try {
            Patient patient = patientRepository.save(new Patient()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .birthDate(request.getBirthDate())
                    .gender(request.getGender()));

            if (request.getFeedbacks() != null && !request.getFeedbacks().isEmpty()) {
                List<FeedbackDto> feedbackDtos = request.getFeedbacks();

                for (FeedbackDto dto : feedbackDtos) {
                    Feedback feedback = feedbackRepository.save(new Feedback()
                            .patientId(patient.getId())
                            .npi(dto.getNpi())
                            .rating(dto.getRating())
                            .comment(dto.getComment()));

                    patient.getFeedbacks().add(feedback);
                    patientRepository.save(patient);
                }
            }

            return new ResponseEntity<>(patient, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable UUID id, @RequestBody @Valid PatientUpdateDto request) {
        Optional<Patient> existing = patientRepository.findById(id);

        if (existing.isPresent()) {
            Patient update = existing.get();
            update.setFirstName(request.getFirstName());
            update.setLastName(request.getLastName());
            update.setBirthDate(request.getBirthDate());
            update.setGender((request.getGender()));
            return new ResponseEntity<>(patientRepository.save(update), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatientById(@PathVariable UUID id) {
        try {
            patientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllPatients() {
        try {
            patientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
