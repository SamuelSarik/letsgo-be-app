package sk.app.lg.factory;

import sk.app.lg.User;
import sk.app.lg.dto.UserRequest;

public final class UserFactory {

    public static User createUser(UserRequest request) {
        return User.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .position(request.getPosition())
                .email(request.getEmail())
                .build();
    }
}
