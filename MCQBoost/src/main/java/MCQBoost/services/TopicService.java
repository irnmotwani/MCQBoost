package MCQBoost.services;

import MCQBoost.entities.Topic;
import MCQBoost.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Optional<Topic> createTopic(String name) {
        // Check if the topic already exists by name
        Optional<Topic> existingTopic = topicRepository.findByName(name);
        
        // If the topic exists, return it
        if (existingTopic.isPresent()) {
            return existingTopic;
        }
        
        // Create a new topic if it doesn't exist
        Topic newTopic = new Topic(name);
        Topic savedTopic = topicRepository.save(newTopic);
        
        // Return the saved topic wrapped in Optional
        return Optional.of(savedTopic);
    }
}
