package sk.app.lg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
public final class UserRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String position;
    private String email;

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("birthDate")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }
}
