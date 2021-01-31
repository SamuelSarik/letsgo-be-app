package sk.app.lg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
public class RealizationRequest {

    private UUID id;
    private UUID userId;
    private UUID eventId;
    private LocalDateTime notifiedAt;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("userId")
    public UUID getUserId() {
        return userId;
    }

    @JsonProperty("eventId")
    public UUID getEventId() {
        return eventId;
    }

    @JsonProperty("notifiedAt")
    public LocalDateTime getNotifiedAt() {
        return notifiedAt;
    }
}
