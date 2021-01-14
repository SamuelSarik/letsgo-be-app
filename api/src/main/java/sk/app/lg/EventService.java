package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.repository.EventRepository;

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
    }e

    public Optional<Event> find(UUID id) {
        return eventRepository.findById(id);
    }
}
