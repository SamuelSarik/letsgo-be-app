package sk.app.lg.exceptionhandling;

import org.springframework.http.ResponseEntity;
import sk.app.lg.error.CustomException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExceptionHandler {

    public static ResponseEntity createCustomErrorResponse (CustomException e) {
        if (e.getCode() == 1) {
            return ResponseEntity.status(500).body(mapper(e));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private static Map<Object, Object> mapper(CustomException e) {
        Map attributes = new HashMap();
        attributes.put("code", e.getCode());
        attributes.put("message", e.getMessage());
        return attributes;
    }
}
