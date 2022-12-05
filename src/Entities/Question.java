package Entities;

//bu siniftan direkt olarak nesne uretilmesini istemedigim icin abstract tanimliyorum
public abstract class Question implements Comparable<Question> {
    private String text;
    private String correctAnswer;
    private int score;
    private String difficulty;

    public Question(String text, String correctAnswer, int score, String difficulty) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.score = score;
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Sorular Comparable arayüzünü gerçekleştirdiği için puanlarına göre küçükten büyüğe doğru sıralanacaktır.
    @Override
    public int compareTo(Question other) {
        return Integer.compare(this.score, other.score);
    }
}
