package sk.app.lg.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//TODO immutable maybe
public class CustomException extends Throwable {

    //TODO some exception enumerator would be better
    ValidatorCode code;

    //TODO when immutable will be used then delete this
    public CustomException(ValidatorCode code) {
        this.code = code;
    }
}
