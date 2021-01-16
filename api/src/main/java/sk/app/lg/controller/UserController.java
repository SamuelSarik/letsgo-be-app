package sk.app.lg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.app.lg.User;
import sk.app.lg.UserService;
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
    public ResponseEntity insert(@RequestBody User user) {
        return ResponseEntity.ok(userService.insert(user));
    }

    @GetMapping(path = USER_URI)
    public ResponseEntity detail(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @GetMapping(path = USERS_URI)
    public ResponseEntity list() {
        return ResponseEntity.ok(userService.findAll());
    }
}
