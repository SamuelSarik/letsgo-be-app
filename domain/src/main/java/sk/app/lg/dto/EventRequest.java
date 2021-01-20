package sk.app.lg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public final class EventRequest {

    private UUID id;
    private String name;
    private String place;
    private LocalDateTime timeOfEvent;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
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
