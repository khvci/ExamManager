package Entities;

import java.util.List;

public class Exam {
    private Question[] questions;
    private String type;

    public Exam(List<Question> questions, String type) {
        this.questions = questions;
        this.type = type;
    }



    public Question[] getQuestions() {
        return this.questions;
    }

    public String getType() {
        return this.type;
    }

}
