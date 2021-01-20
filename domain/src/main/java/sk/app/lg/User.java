package sk.app.lg;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
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
    private String birthDate;

    @NotBlank
    @Size(max = 50)
    @Column(name = "position")
    @NotBlank
    private String position;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.position = builder.position;
        this.email = builder.email;
    }

    public static class UserBuilder {

        private UUID id;
        private String firstName;
        private String lastName;
        private String birthDate;
        private String position;
        private String email;

        public UserBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder birthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder position(String position) {
            this.position = position;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
}
