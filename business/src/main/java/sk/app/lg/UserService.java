package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.dto.UserRequest;
import sk.app.lg.error.CustomException;
import sk.app.lg.error.ValidatorCode;
import sk.app.lg.factory.UserFactory;
import sk.app.lg.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static sk.app.lg.error.ValidatorCode.USER_WITH_ID_DOES_NOT_EXIST;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(UserRequest request) {
        final User user = UserFactory.createUser(request);
        return userRepository.save(user);
    }

    public Optional<User> findById(UUID id) throws CustomException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new CustomException(USER_WITH_ID_DOES_NOT_EXIST);
        }
        return user;
    }

    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }
}
