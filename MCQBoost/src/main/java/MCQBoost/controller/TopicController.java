package MCQBoost.controller;

import MCQBoost.entities.Topic;
import MCQBoost.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    // Endpoint to create a topic
    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody String topicName) {
        // Create topic and get the Optional<Topic> response from service
        Optional<Topic> optionalTopic = topicService.createTopic(topicName);
        
        // If the topic was created or already exists, return it
        if (optionalTopic.isPresent()) {
            return ResponseEntity.ok(optionalTopic.get());
        } else {
            // If somehow no topic was created (shouldn't happen), return an error response
            return ResponseEntity.status(400).build(); // Bad Request if not created
        }
    }
}
