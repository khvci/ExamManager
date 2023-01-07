package Entities;

public class ClassicQuestion extends Question {
    public ClassicQuestion(String text, String correctAnswer, int score, String difficulty) {
        super(text, correctAnswer, score, difficulty);
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(this.getCorrectAnswer());
    }

    @Override
    public String getType() {
        return "klasik";
    }
}
