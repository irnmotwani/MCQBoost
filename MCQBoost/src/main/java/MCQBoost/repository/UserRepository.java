package MCQBoost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import MCQBoost.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods if necessary
    User findByUsername(String username);
}
