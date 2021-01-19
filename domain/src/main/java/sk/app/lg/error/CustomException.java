package sk.app.lg.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//TODO immutable maybe
public class CustomException extends Throwable{

    //TODO some exception enumerator would be better
    Integer code;

    String message;

    //TODO when immutable will be used then delete this
    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
