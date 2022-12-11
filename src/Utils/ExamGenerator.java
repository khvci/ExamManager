package Utils;

import Entities.ClassicQuestion;
import Entities.Exam;
import Entities.MultipleChoiceQuestion;
import Entities.Question;

import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExamGenerator {
    private static List<Question> questionBank;
    private static List<Question> examQuestions;

    public static Exam generateExam(List<Question> questionBank, String examType) {
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
        Collections.shuffle(examQuestions);
        int totalScore = 0;
        for (Question question : examQuestions) {
            totalScore += question.getScore();
            if (totalScore > 110) {
                examQuestions.remove(question);
                break;
            }
        }

        return new Exam(examQuestions, examType);



    }

    public static List<Question> printExam(Exam exam) {
        System.out.println("Sınav Türü: " + exam.getExamType());
        System.out.println("Sınav Soruları:");
        for (Question question : exam.getQuestions()) {
            System.out.println(question);
        }
        if (exam.getExamType().equals("test")) {
            System.out.println("Sınav Notu: " + exam.getScore());
        }
        return exam.getQuestions();


}

    public static void saveExam(Exam exam) {
        try {
            FileWriter fileWriter = new FileWriter("sinav.txt");
            fileWriter.write(exam.getQuestions().toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Dosya oluşturulamadı");
        }
    }
}

