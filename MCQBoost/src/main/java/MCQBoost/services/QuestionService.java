package MCQBoost.services;

import MCQBoost.entities.Question;
import MCQBoost.entities.Difficulty;
import MCQBoost.entities.Topic;
import MCQBoost.repository.QuestionRepository;
import MCQBoost.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TopicRepository topicRepository;

    private final String OPEN_TDB_URL = "https://opentdb.com/api.php?amount=5&type=multiple"; // Basic API URL (modify as per your needs)
    
    private RestTemplate restTemplate = new RestTemplate();

    // Method to generate questions dynamically
    public List<Question> generateQuestions(String topicName, int amount, Difficulty difficulty) {
        String apiUrl = OPEN_TDB_URL + "&difficulty=" + difficulty.name().toLowerCase();

        // Fetch questions from the OpenTDB API
        Question[] questions = restTemplate.getForObject(OPEN_TDB_URL, Question[].class);

        if (questions == null || questions.length == 0) {
            throw new RuntimeException("No questions found from external API.");
        }

        // Loop through and save questions into your database
        for (Question question : questions) {
            Topic topic = topicRepository.findByName(topicName).orElseThrow(() -> 
                new RuntimeException("Topic not found"));

            question.setTopic(topic);
            question.setDifficulty(difficulty);
            questionRepository.save(question);
        }

        return List.of(questions);
    }
}
