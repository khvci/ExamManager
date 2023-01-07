package Utils;

import Entities.ClassicQuestion;
import Entities.Exam;
import Entities.MultipleChoiceQuestion;
import Entities.Question;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExamGenerator {
    private static List<Question> questionBank;
    private static List<Question> examQuestions;

    public static Exam generateExam(List<Question> questionBank, String examType, String difficulty) {
        ExamGenerator.questionBank = questionBank;
        examQuestions = questionBank;

        switch (examType) {
            case "test":
                examQuestions = questionBank.stream()
                        .filter(q -> q instanceof MultipleChoiceQuestion)
                        .collect(Collectors.toList());
                break;
            case "klasik":
                examQuestions = questionBank.stream()
                        .filter(q -> q instanceof ClassicQuestion)
                        .collect(Collectors.toList());
                break;
            case "karışık":
                examQuestions = questionBank;
                break;
        }

        switch (difficulty) {
            case "zor":
                examQuestions = examQuestions.stream()
                        .filter(q -> q.getDifficulty().equals("zor") || q.getDifficulty().equals("orta"))
                        .collect(Collectors.toList());
                break;
            case "orta":
                examQuestions = examQuestions.stream()
                        .filter(q -> q.getDifficulty().equals("zor") || q.getDifficulty().equals("orta") || q.getDifficulty().equals("kolay"))
                        .collect(Collectors.toList());
                break;
            case "kolay":
                examQuestions = examQuestions.stream()
                        .filter(q -> q.getDifficulty().equals("orta") || q.getDifficulty().equals("kolay"))
                        .collect(Collectors.toList());
                break;
        }

        Collections.shuffle(examQuestions);
        return new Exam(examQuestions, examType);
    }
}

