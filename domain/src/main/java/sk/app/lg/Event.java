package sk.app.lg;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "category")
    private String category;

    @NotBlank
    @Size(max = 100)
    @Column(name = "place")
    private String place;

    @Column(name = "time_of_event")
    private LocalDateTime timeOfEvent;

    private Event(EventBuilder builder) {
        this.id = builder.id;
        this.category = builder.category;
        this.place = builder.place;
        this.timeOfEvent = builder.timeOfEvent;
    }

    public static class EventBuilder {

        private UUID id;
        private String category;
        private String place;
        private LocalDateTime timeOfEvent;

        public EventBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public EventBuilder category(String category) {
            this.category = category;
            return this;
        }

        public EventBuilder place(String place) {
            this.place = place;
            return this;
        }

        public EventBuilder timeOfEvent(LocalDateTime timeOfEvent) {
            this.timeOfEvent = timeOfEvent;
            return this;
        }

        public Event build() {
            Event event = new Event(this);
            return event;
        }
    }
}
