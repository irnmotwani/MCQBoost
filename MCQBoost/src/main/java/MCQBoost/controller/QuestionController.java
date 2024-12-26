package MCQBoost.controller;

import MCQBoost.entities.Difficulty;
import MCQBoost.entities.Question;
import MCQBoost.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/generate")
    public ResponseEntity<Object> generateQuestions(
            @RequestParam String topicName,
            @RequestParam int amount,
            @RequestParam Difficulty difficulty) {

        try {
            // Validate the inputs
            if (topicName == null || topicName.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Topic name is required"));
            }
            if (amount <= 0) {
                return ResponseEntity.badRequest().body(Map.of("error", "Amount must be greater than 0"));
            }

            // Call the service to generate questions
            List<Question> questions = questionService.generateQuestions(topicName, amount, difficulty);

            // Return the list of questions if successful
            return ResponseEntity.ok().body(questions);
        } catch (Exception e) {
            // Log the exception (optional for debugging)
            e.printStackTrace();
            // Return a generic error message with the exception details
            return ResponseEntity.status(500).body(Map.of("error", "Error generating questions: " + e.getMessage()));
        }
    }
}
