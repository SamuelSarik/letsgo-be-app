package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.Event;
import sk.app.lg.EventService;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EventController extends BaseController {

    private EventService eventService;

    public static final String EVENTS_URI = BASE_URI + "/events";
    public static final String EVENT_URI = EVENTS_URI + "/{eventId}";

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(path = EVENTS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody Event event){
        return ResponseEntity.ok(eventService.insert(event));
    }

    @GetMapping(path = EVENT_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity detail(@PathVariable UUID eventId){
        return ResponseEntity.ok(eventService.findById(eventId));
    }

    @GetMapping(path = EVENTS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity list() {
        return ResponseEntity.ok(eventService.findAll());
    }
}
