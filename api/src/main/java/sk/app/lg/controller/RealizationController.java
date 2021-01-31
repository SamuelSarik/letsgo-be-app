package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.RealizationService;
import sk.app.lg.dto.RealizationRequest;
import sk.app.lg.error.CustomException;
import sk.app.lg.handler.ExceptionHandler;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static sk.app.lg.controller.BaseController.BASE_URI;

@RestController
public class RealizationController {

    private RealizationService realizationService;

    public static final String REALIZATIONS_URI = BASE_URI + "/realizations";
    public static final String REALIZATION_URI = REALIZATIONS_URI + "/{realizationId}";

    @Autowired
    public RealizationController(RealizationService realizationService) {
        this.realizationService = realizationService;
    }

    @PostMapping(path = REALIZATIONS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody RealizationRequest request){
        return ResponseEntity.ok(realizationService.register(request));
    }

    @GetMapping(path = REALIZATION_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity detail(@PathVariable UUID realizationId){
        try {
            return ResponseEntity.ok(realizationService.findById(realizationId));
        } catch (CustomException e) {
            return ExceptionHandler.createCustomErrorResponse(e, realizationId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }
}
