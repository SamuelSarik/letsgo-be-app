package sk.app.lg;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
