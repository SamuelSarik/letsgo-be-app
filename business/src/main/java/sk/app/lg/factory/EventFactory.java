package sk.app.lg.factory;

import sk.app.lg.Event;
import sk.app.lg.dto.EventRequest;

public final class EventFactory {

    public static Event createEvent(EventRequest request) {
        return Event.builder()
                .id(request.getId())
                .category(request.getCategory().toString())
                .place(request.getPlace())
                .timeOfEvent(request.getTimeOfEvent())
                .build();
    }
}
