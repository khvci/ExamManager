package Utils;

import Entities.ClassicQuestion;
import Entities.MultipleChoiceQuestion;
import Entities.Question;

import java.util.Collections;
import java.util.List;

public class ExamGenerator {
    private static List<Question> questionBank;
    private static List<Question> examQuestions;



    public static void generateExam(String examType, int numberOfQuestions) {
        if (examType.equals("test")) {
            // Select only multiple choice questions
            for (Question question : questionBank) {
                if (question instanceof MultipleChoiceQuestion) {
                    examQuestions.add(question);
                }
            }
        } else if (examType.equals("classic")) {
            // Select only classic questions
            for (Question question : questionBank) {
                if (question instanceof ClassicQuestion) {
                    examQuestions.add(question);
                }
            }
        } else {
            // Select all question types
            examQuestions = questionBank;
        }

        // Shuffle the list of questions and select the first "numberOfQuestions" number of questions
        Collections.shuffle(examQuestions);
        examQuestions = examQuestions.subList(0, numberOfQuestions);

        // Calculate total score and make sure it is within the range of 100-110
        int totalScore = 0;
        for (Question question : examQuestions) {
            totalScore += question.getScore();
        }
        if (totalScore < 100) {
            // Increase score of the last question until total score is within the desired range
            Question lastQuestion = examQuestions.get(examQuestions.size() - 1);
            lastQuestion.setScore(lastQuestion.getScore() + (100 - totalScore));
        } else if (totalScore > 110) {
            // Decrease score of the last question until total score is within the desired range
            Question lastQuestion = examQuestions.get(examQuestions.size() - 1);
            lastQuestion.setScore(lastQuestion.getScore() - (totalScore - 110));
        }
    }

    public static List<Question> getExamQuestions() {
        return examQuestions;
    }
}