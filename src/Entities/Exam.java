package Entities;

import java.util.List;

public class Exam {
    private List<Question> questions;
    private String type;

    public Exam(List<Question> questions, String type) {
        this.questions = questions;
        this.type = type;
    }



    public List<Question> getQuestions() {
        return this.questions;
    }

    public String getType() {
        return this.type;
    }

    public String getExamType() {
        return this.type;
    }

    public int getScore() {
        int totalScore = 0;
        for (Question question : questions) {
            totalScore += question.getScore();
        }
        return totalScore;
    }
}
