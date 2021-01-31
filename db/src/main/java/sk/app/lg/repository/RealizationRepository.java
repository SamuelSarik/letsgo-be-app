package sk.app.lg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.app.lg.Realization;

import java.util.UUID;

@Repository
public interface RealizationRepository extends JpaRepository<Realization, UUID> {
}
