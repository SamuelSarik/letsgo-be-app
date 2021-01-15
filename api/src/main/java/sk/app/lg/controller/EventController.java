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

    @Autowired
    EventService eventService;

    public static final String EVENTS_URI = BASE_URI + "/events";
    public static final String EVENT_URI = EVENTS_URI + "/{eventId}";

    @GetMapping(path = "/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("Test is ok");
    }

    @GetMapping(path = EVENT_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getEvent(@PathVariable UUID eventId){
        return ResponseEntity.ok(eventService.find(eventId));
    }

    @PostMapping(path = EVENTS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity insertEvent(@RequestBody Event event){
        return ResponseEntity.ok(eventService.insert(event));
    }
}
