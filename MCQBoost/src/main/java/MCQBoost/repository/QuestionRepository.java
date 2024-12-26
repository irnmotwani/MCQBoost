package MCQBoost.repository;

import MCQBoost.entities.Question;
import MCQBoost.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Find questions by topic
    List<Question> findByTopic(Topic topic);
}
