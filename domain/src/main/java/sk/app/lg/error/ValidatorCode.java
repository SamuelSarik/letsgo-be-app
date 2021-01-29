package sk.app.lg.error;

import java.text.MessageFormat;

public enum ValidatorCode {

    EVENT_WITH_ID_DOES_NOT_EXIST("Event with ID ''{0}'' does not exist."),
    USER_WITH_ID_DOES_NOT_EXIST("User with ID ''{0}'' does not exist.");

    private final String template;

    ValidatorCode(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return this.template;
    }

    public String getMessage(String... params) {
        return MessageFormat.format(this.template, (Object[]) params);
    }
}
