package sk.app.lg;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    UUID id;

    @Setter
    @Column(name = "first_name")
    String firstName;

    @Setter
    @Column(name = "last_name")
    String lastName;

    @Setter
    @Column(name = "birth_date")
    String birthDate;

    @Setter
    @Column(name = "position")
    String position;

    @Setter
    @Column(name = "email")
    String email;
}
