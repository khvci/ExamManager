package Entities;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> choices;

    public MultipleChoiceQuestion(String text, String correctAnswer, int score, String difficulty, List<String> choices) {
        super(text, correctAnswer, score, difficulty);
        this.choices = choices;
    }

    public List<String> getChoices() {
        return this.choices;
    }


    public boolean checkAnswer(int choice) {
        return choices.get(choice).equalsIgnoreCase(this.getCorrectAnswer());
    }
}
