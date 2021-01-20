package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.dto.UserRequest;
import sk.app.lg.UserService;
import sk.app.lg.error.CustomException;
import sk.app.lg.handler.ExceptionHandler;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController extends BaseController{

    private UserService userService;

    public static final String USERS_URI = BASE_URI + "/users";
    public static final String USER_URI = USERS_URI + "/{userId}";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = USERS_URI, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping(path = USER_URI)
    public ResponseEntity detail(@PathVariable UUID userId) {
        try {
            return ResponseEntity.ok(userService.findById(userId));
        } catch (CustomException e) {
            return ExceptionHandler.createCustomErrorResponse(e);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }

    @GetMapping(path = USERS_URI)
    public ResponseEntity list() {
        return ResponseEntity.ok(userService.findAll());
    }
}
