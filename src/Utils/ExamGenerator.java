package Utils;

import Entities.ClassicQuestion;
import Entities.Exam;
import Entities.MultipleChoiceQuestion;
import Entities.Question;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// This class is responsible for generating exams using the Strategy Design Pattern
public class ExamGenerator {
    private static List<Question> questionBank;
    private static List<Question> examQuestions;

    // This method generates an exam based on the given exam type and difficulty level
    public static Exam generateExam(List<Question> questionBank, String examType, String difficulty) {
        ExamGenerator.questionBank = questionBank;
        examQuestions = questionBank;

        // Determine which questions to include in the exam based on the exam type
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

        // Filter the questions based on the difficulty level
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

        // Shuffle the questions and create the exam object
        Collections.shuffle(examQuestions);
        return new Exam(examQuestions, examType);
    }
}

