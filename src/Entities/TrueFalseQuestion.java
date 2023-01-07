package Entities;

public class TrueFalseQuestion extends Question {
    public TrueFalseQuestion(String text, String correctAnswer, int score, String difficulty) {
        super(text, correctAnswer, score, difficulty);
    }

    @Override
    public String getType() {
        return "dogru_yanlis";
    }
    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(this.getCorrectAnswer());
    }
}
