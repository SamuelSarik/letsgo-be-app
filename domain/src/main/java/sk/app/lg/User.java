package sk.app.lg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 50)
    @Column(name = "position")
    @NotBlank
    private String position;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;
}
