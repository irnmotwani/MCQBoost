package MCQBoost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import MCQBoost.entities.Topic;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    // This method returns an Optional<Topic>
    Optional<Topic> findByName(String name);
}
