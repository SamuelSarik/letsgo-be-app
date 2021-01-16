package sk.app.lg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public User insert(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(UUID personId) {
        return userRepository.findById(personId);
    }

    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }
}
