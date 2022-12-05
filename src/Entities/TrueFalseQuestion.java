package Entities;

import Entities.Question;

public class TrueFalseQuestion extends Question {


    public TrueFalseQuestion(String text, String correctAnswer, int score, String difficulty) {
        super(text, correctAnswer, score, difficulty);
    }

    public boolean checkAnswer(String answer) {
        // Kullanıcının girdiği cevap ile sorunun doğru cevabını karşılaştır
        return answer.equalsIgnoreCase(this.getCorrectAnswer());
    }
}
