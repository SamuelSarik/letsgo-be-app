package sk.app.lg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.app.lg.Person;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
}
