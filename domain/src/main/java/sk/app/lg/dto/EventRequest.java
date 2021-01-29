package sk.app.lg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import sk.app.lg.EventCategory;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public final class EventRequest {

    private UUID id;
    private EventCategory category;
    private String place;
    private LocalDateTime timeOfEvent;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("category")
    public EventCategory getCategory() {
        return category;
    }

    @JsonProperty("place")
    public String getPlace() {
        return place;
    }

    @JsonProperty("timeOfEvent")
    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }
}
