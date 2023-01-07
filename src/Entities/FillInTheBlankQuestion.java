package Entities;

public class FillInTheBlankQuestion extends Question {

    public FillInTheBlankQuestion(String text, String correctAnswer, int score, String difficulty) {
        super(text, correctAnswer, score, difficulty);
    }
    public String getType() {
        return "bosluk_doldurma";
    }
    public String getCorrectAnswer() {
        return this.getCorrectAnswer();
    }
}
