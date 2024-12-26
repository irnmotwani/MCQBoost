package MCQBoost.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MCQBoost.entities.User;
import MCQBoost.repository.UserRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // You could add some validation or hashing the password here
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

