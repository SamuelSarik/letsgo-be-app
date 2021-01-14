package sk.app.lg;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    UUID id;

    @Setter
    @Column(name = "name")
    String name;

    @Setter
    @Column(name = "place")
    String place;

    @Setter
    @Column(name = "time_of_event")
    LocalDateTime timeOfEvent;
}
