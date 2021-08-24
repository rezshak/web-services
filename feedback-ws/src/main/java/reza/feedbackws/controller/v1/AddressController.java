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
import reza.feedbackws.dto.AddressDto;
import reza.feedbackws.dto.AddressUpdateDto;
import reza.feedbackws.model.Address;
import reza.feedbackws.repository.AddressRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/address")
@Validated
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/")
    public ResponseEntity<List<Address>> listAllAddresses() {
        try {
            List<Address> addresses = new ArrayList<>(addressRepository.findAll());
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable UUID id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()) {
            return new ResponseEntity<>(address.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Address> createAddress(@RequestBody @Valid AddressDto request) {
        try {
            Address address = addressRepository.save(new Address()
                    .use(request.getUse())
                    .line(request.getLine())
                    .line2(request.getLine2())
                    .city(request.getCity())
                    .state(request.getState())
                    .zip(request.getZip()));
            return new ResponseEntity<>(address, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody @Valid AddressUpdateDto request) {
        Optional<Address> existing = addressRepository.findById(id);

        if (existing.isPresent()) {
            Address update = existing.get();
            update.use((request.getUse()));
            update.setLine(request.getLine());
            update.setLine2(request.getLine2());
            update.setCity(request.getCity());
            update.setState(request.getState());
            update.setZip(request.getZip());
            return new ResponseEntity<>(addressRepository.save(update), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAddressById(@PathVariable UUID id) {
        try {
            addressRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllAddresses() {
        try {
            addressRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
