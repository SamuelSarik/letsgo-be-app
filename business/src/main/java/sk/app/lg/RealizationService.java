package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.dto.RealizationRequest;
import sk.app.lg.error.CustomException;
import sk.app.lg.factory.RealizationFactory;
import sk.app.lg.repository.RealizationRepository;
import java.util.Optional;
import java.util.UUID;

import static sk.app.lg.error.ValidatorCode.REALIZATION_WITH_ID_DOES_NOT_EXIST;

@Service
public class RealizationService {

    private RealizationRepository realizationRepository;

    @Autowired
    public RealizationService(RealizationRepository realizationRepository) {
        this.realizationRepository = realizationRepository;
    }

    public Realization register(RealizationRequest request) {
        final Realization realization = RealizationFactory.createRealization(request);
        return realizationRepository.save(realization);
    }

    public Optional<Realization> findById(UUID id) throws CustomException {
        Optional<Realization> realization = realizationRepository.findById(id);
        if (realization.isEmpty()) {
            throw new CustomException(REALIZATION_WITH_ID_DOES_NOT_EXIST);
        }
        return realization;
    }
}
