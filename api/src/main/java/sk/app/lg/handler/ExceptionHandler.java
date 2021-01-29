package sk.app.lg.handler;

import org.springframework.http.ResponseEntity;
import sk.app.lg.error.CustomException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static sk.app.lg.error.ValidatorCode.EVENT_WITH_ID_DOES_NOT_EXIST;
import static sk.app.lg.error.ValidatorCode.USER_WITH_ID_DOES_NOT_EXIST;

public class ExceptionHandler {

    public static final String CODE = "code";
    public static final String MESSAGE = "message";

    public static ResponseEntity createCustomErrorResponse (CustomException e, UUID id) {
        if (e.getCode() == EVENT_WITH_ID_DOES_NOT_EXIST || e.getCode() == USER_WITH_ID_DOES_NOT_EXIST) {
            return ResponseEntity.status(500).body(mapper(e, id));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private static Map<Object, Object> mapper(CustomException e, UUID id) {
        Map attributes = new HashMap();
        attributes.put(CODE, e.getCode());
        attributes.put(MESSAGE, e.getCode().getMessage(String.valueOf(id)));
        return attributes;
    }
}
