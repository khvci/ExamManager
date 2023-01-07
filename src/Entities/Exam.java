package Entities;

import java.util.List;

public class Exam {
    private List<Question> questions;
    private String type;
    private String difficulty;

    public Exam(List<Question> questions, String type, String difficulty) {
        this.questions = questions;
        this.type = type;
        this.difficulty = difficulty;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public String getType() {
        return this.type;
    }

    public String getDifficulty() {
        return this.difficulty;
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