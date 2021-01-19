package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.error.CustomException;
import sk.app.lg.repository.EventRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Event insert(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> find(UUID id) throws CustomException {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            throw new CustomException(1, "Event with id " + id + " does not exist");
        }
        return event;
    }

    public Optional<List<Event>> findAll() {
        return Optional.of(eventRepository.findAll());
    }
}
