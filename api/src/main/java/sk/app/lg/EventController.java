package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(path = "/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("Test is ok");
    }

    @GetMapping(path = "/event/{id}")
    public ResponseEntity getEvent(@PathVariable UUID id){
        return ResponseEntity.ok(eventService.find(id));
    }

    @PostMapping(path = "/event")
    public ResponseEntity insertEvent(@RequestBody Event event){
        return ResponseEntity.ok(eventService.insert(event));
    }
}
