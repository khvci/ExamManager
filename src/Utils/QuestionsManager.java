package Utils;

import Entities.Question;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionsManager {
    private static List<Question> questions; // Soru bankası

    public QuestionsManager() {
        this.questions = new ArrayList<>();
    }

    // Soru ekleme metodu
    public static void addQuestion(Question question) {
        questions.add(question);
    }

    // Soru silme metodu
    public static void removeQuestion(String text) {
        // Soru metni ile eşleşen soruyu bulalım
        Optional<Question> optionalQuestion = questions.stream()
                .filter(q -> q.getText().contains(text)) // Soru metninde arama kelimesi geçiyor mu
                .findFirst(); // İlk eşleşen soruyu döndür

        // Eşleşen bir soru varsa sil
        optionalQuestion.ifPresent(q -> questions.remove(q));
    }

    // Soruları filtreleme metodu
    public static List<Question> listQuestionsToRemove(String text) {
        // Soru metni ile eşleşen soruları bulalım
        List<Question> filteredQuestions = questions.stream()
                .filter(q -> q.getText().contains(text)) // Soru metninde arama kelimesi geçiyor mu
                .collect(Collectors.toList()); // Bulunan soruları bir listeye ekleyelim

        // Filtrelenen soruları döndürelim
        return filteredQuestions;
    }

    // Kullanıcıdan alınan indekste bulunan soruyu silelim
    public static void removeQuestion(int indexToRemove) {
        questions.remove(indexToRemove);
    }


    // Soru bankasındaki soruları listeleme metotları:
    // Sorular Comparable arayüzünü gerçekleştirdiği için puanlarına göre küçükten büyüğe doğru sıralanmıştır.

    public static List<Question> listQuestionsByText(String text) {
        // Soru metni içinde arama yapmak için metot
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getText().contains(text)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByAnswerText(String text) {
        // Soru şıklarının metinleri içinde arama yapmak için metot
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getCorrectAnswer().contains(text)) {
                filteredQuestions.add(question);
                break;
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByCorrectAnswer(String correctAnswer) {
        // Doğru şıkları üzerinden arama yapmak için metot
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getCorrectAnswer().equalsIgnoreCase(correctAnswer)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByPoints(String stringPoints) {
        // Puan üzerinden arama yapmak için metot
        int points = Integer.parseInt(stringPoints); // listByUserChoice() metodunda user input String gelecegi icin String alip int'e ceviriyorum
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getScore() == points) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByDifficulty(String difficulty) {
        // Zorluk derecesi üzerinden arama yapmak için metot
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getDifficulty().equalsIgnoreCase(difficulty)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static void listByUserChoice(int choice, String userInput) {
        switch (choice) {
            case 1:
                listQuestionsByText(userInput);
                break;
            case 2:
                listQuestionsByAnswerText(userInput);
                break;
            case 3:
                listQuestionsByCorrectAnswer(userInput);
                break;
            case 4:
                listQuestionsByPoints(userInput);
                break;
            case 5:
                listQuestionsByDifficulty(userInput);
                break;
        }
    }
}