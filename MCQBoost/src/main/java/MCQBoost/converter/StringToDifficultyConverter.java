package MCQBoost.converter;

import MCQBoost.entities.Difficulty;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDifficultyConverter implements Converter<String, Difficulty> {

    @Override
    public Difficulty convert(String source) {
        if (source == null) {
            return null;
        }

        // Convert the input string to lowercase and match it with the enum values
        switch (source.trim().toLowerCase()) {
            case "easy":
                return Difficulty.EASY;
            case "medium":
                return Difficulty.MEDIUM;
            case "hard":
                return Difficulty.HARD;
            default:
                throw new IllegalArgumentException("Invalid difficulty level. Valid values are easy, medium, hard.");
        }
    }
}
