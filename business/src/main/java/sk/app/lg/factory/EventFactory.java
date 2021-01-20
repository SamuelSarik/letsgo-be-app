package sk.app.lg.factory;

import sk.app.lg.Event;
import sk.app.lg.dto.EventRequest;

public final class EventFactory {

    public static Event createEvent(EventRequest request) {
        return new Event.EventBuilder()
                .id(request.getId())
                .name(request.getName())
                .place(request.getPlace())
                .timeOfEvent(request.getTimeOfEvent())
                .build();
    }
}
