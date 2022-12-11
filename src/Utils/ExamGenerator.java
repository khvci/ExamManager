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


/*
Puan toplamı 100-110 arasında olacak şekilde soru bankasından rasgele sorular seçilerek bir sınav oluşturulacaktır. Üç farklı sınav türü olacaktır.  test (sadece MultipleChoiceQuestion içeren), klasik sınav (sadece klasik sorulardan üretilmeli) veüçüncüsü
karışık
sınav
(tüm
soru
tiplerinden
içerisinde
bulunabilmeli)
türüdür.
 */




    public static Exam generateExam(List<Question> questionBank, String examType) {
        ExamGenerator.questionBank = questionBank;
        examQuestions = questionBank;
        switch (examType) {
            case "test":
                // test (sadece MultipleChoiceQuestion içeren)
                examQuestions = questionBank.stream()
                        .filter(q -> q instanceof MultipleChoiceQuestion)
                        .collect(Collectors.toList());
                break;
            case "klasik":

                // klasik sınav (sadece klasik sorulardan üretilmeli)
                examQuestions = questionBank.stream()
                        .filter(q -> q instanceof ClassicQuestion)
                        .collect(Collectors.toList());
                break;
            case "karışık":
                // karışık sınav (tüm soru tiplerinden içerisinde bulunabilmeli)
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

    //Sınav
    //oluşturulduğunda
    //ekranda
    //sorular
    //sırasıyla
    //kullanıcılara
    //sorulmalı ve sınav cevapları ile birlikte "sinav.txt" adlı bir
    //dosyaya kaydedilmelidir. Sadece test sınavları için sınav
    //sonunda sınavdan alınan not ekranda yazılmalıdır
    public static void printExam(Exam exam) {
        System.out.println("Sınav Türü: " + exam.getExamType());
        System.out.println("Sınav Soruları:");
        for (Question question : exam.getQuestions()) {
            System.out.println(question);
        }
        if (exam.getExamType().equals("test")) {
            System.out.println("Sınav Notu: " + exam.getScore());
        }

    }
    public static List<Question> getExamQuestions() {
        return examQuestions;
    }
}