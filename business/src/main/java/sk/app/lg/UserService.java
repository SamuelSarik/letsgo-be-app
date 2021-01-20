package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.app.lg.dto.UserRequest;
import sk.app.lg.error.CustomException;
import sk.app.lg.factory.UserFactory;
import sk.app.lg.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
            throw new CustomException(1, "User with id " + id + " does not exist");
        }
        return user;
    }

    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }
}
