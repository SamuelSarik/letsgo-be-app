package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.Person;
import sk.app.lg.PersonService;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PersonController extends BaseController{

    private PersonService personService;

    public static final String PERSONS_URI = BASE_URI + "/persons";
    public static final String PERSON_URI = PERSONS_URI + "/{personId}";

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = PERSONS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity insertPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.insert(person));
    }

    @GetMapping(path = PERSON_URI)
    public ResponseEntity getPerson(@PathVariable UUID personId) {
        return ResponseEntity.ok(personService.findById(personId));
    }

    @GetMapping(path = PERSONS_URI)
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }
}
