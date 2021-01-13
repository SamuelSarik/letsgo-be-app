package sk.app.lg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(path = "/test")
    public ResponseEntity test(){
        return ResponseEntity.ok("Test is ok");
    }
}
