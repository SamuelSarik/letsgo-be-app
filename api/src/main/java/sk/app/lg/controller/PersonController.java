package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.Person;
import sk.app.lg.PersonService;
import java.util.UUID;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path = "/person")
    public ResponseEntity insertPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personService.insert(person));
    }

    @GetMapping(path = "/person/{personId}")
    public ResponseEntity getPerson(@PathVariable UUID personId) {
        return ResponseEntity.ok(personService.findById(personId));
    }

    @GetMapping(path = "/persons")
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok(personService.findAll());
    }
}
