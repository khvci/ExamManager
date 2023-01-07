package Utils;
import Entities.ClassicQuestion;
import Entities.MultipleChoiceQuestion;
import Entities.Question;
import Entities.TrueFalseQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class QuestionsManager {
    private static QuestionsManager instance;
    private static List<Question> questions; // Soru bankası

    private QuestionsManager() {
        this.questions = new ArrayList<>();
    }

    public static QuestionsManager getInstance() {
        if (instance == null) {
            instance = new QuestionsManager();
        }
        return instance;
    }

    public static List<Question> getQuestions() {
        return questions;
    }

    public static void addQuestion(Question question) {
        questions.add(question);
    }

    public static void removeQuestion(String text) {
        Optional<Question> optionalQuestion = questions.stream()
                .filter(q -> q.getText().contains(text))
                .findFirst();

        optionalQuestion.ifPresent(q -> questions.remove(q));
    }

    public static List<Question> listQuestionsToRemove(String text) {
        List<Question> filteredQuestions = questions.stream()
                .filter(q -> q.getText().contains(text))
                .collect(Collectors.toList());

        return filteredQuestions;
    }

    public static void removeQuestion(int indexToRemove) {
        questions.remove(indexToRemove);
    }


    // Sorular Comparable arayüzünü gerçekleştirdiği için puanlarına göre küçükten büyüğe doğru sıralanacaktır.

    public static List<Question> listAllQuestions() {
        return questions;
    }
    public static List<Question> listQuestionsByText(String text) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getText().contains(text)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByAnswerText(String text) {
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
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getCorrectAnswer().equalsIgnoreCase(correctAnswer)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static List<Question> listQuestionsByPoints(String stringPoints) {
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
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question question : questions) {
            if (question.getDifficulty().equalsIgnoreCase(difficulty)) {
                filteredQuestions.add(question);
            }
        }
        return filteredQuestions;
    }

    public static void listByUserChoice(String userInput, int choice) {
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