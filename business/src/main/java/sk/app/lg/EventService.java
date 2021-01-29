package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.dto.EventRequest;
import sk.app.lg.error.CustomException;
import sk.app.lg.factory.EventFactory;
import sk.app.lg.repository.EventRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static sk.app.lg.error.ValidatorCode.EVENT_WITH_ID_DOES_NOT_EXIST;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Event register(EventRequest request) {
        final Event event = EventFactory.createEvent(request);
        return eventRepository.save(event);
    }

    public Optional<Event> findById(UUID id) throws CustomException {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            throw new CustomException(EVENT_WITH_ID_DOES_NOT_EXIST);
        }
        return event;
    }

    public Optional<List<Event>> findAll() {
        return Optional.of(eventRepository.findAll());
    }
}
