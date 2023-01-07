package Utils;

import Entities.ClassicQuestion;
import Entities.FillInTheBlankQuestion;
import Entities.MultipleChoiceQuestion;
import Entities.Question;
import Entities.TrueFalseQuestion;

public class QuestionFactory {
    public static Question createQuestion(String type, String text, String correctAnswer, int score, String difficulty, List<String> choices) {
        switch (type) {
            case "klasik":
                return new ClassicQuestion(text, correctAnswer, score, difficulty);
            case "bosluk_doldurma":
                return new FillInTheBlankQuestion(text, correctAnswer, score, difficulty);
            case "coktan_secmeli":
                return new MultipleChoiceQuestion(text, correctAnswer, score, difficulty, choices);
            case "dogru_yanlis":
                return new TrueFalseQuestion(text, correctAnswer, score, difficulty);
            default:
                throw new IllegalArgumentException("Gecersiz soru tipi girdiniz");
        }
    }
}