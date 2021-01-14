package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person insert(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(UUID personId) {
        return personRepository.findById(personId);
    }

    public Optional<List<Person>> findAll() {
        return Optional.of(personRepository.findAll());
    }
}
