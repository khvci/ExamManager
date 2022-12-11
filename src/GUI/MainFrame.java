package GUI;

import Entities.*;
import Utils.ExamGenerator;
import Utils.QuestionsManager;

import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("Soru Bankası");

        // Frame ayarları
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel oluşturma
        JPanel panel = new JPanel();

        // Butonları oluşturma
        JButton button1 = new JButton("Soru bankasına soru ekleme");
        JButton button2 = new JButton("Soru bankasından soru çıkarma");
        JButton button3 = new JButton("Soru bankasındaki soruları listeleme");
        JButton button4 = new JButton("Sınav oluşturma");
        JButton button5 = new JButton("Çıkış");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        // Paneli frame'e ekleme
        add(panel);

        // Frame'i gösterme
        setVisible(true);

        //when user clicks on button1, it should ask the user to choose the type of question. there are 4 types of questions. ClassicQuestion, FillInTheBlankQuestion, MultipleChoiceQuestion, TrueFalseQuestion. create a question according to user's choice create an instance from related class */
        button1.addActionListener(e -> {
            String questionType = JOptionPane.showInputDialog("Soru tipi seçiniz: \n 1. Sadece cevap alanı sorusu \n 2. Boşluk doldurma sorusu \n 3. Çoktan seçmeli soru \n 4. Doğru yanlış sorusu");
            switch (questionType) {
                case "1":
                    String text = JOptionPane.showInputDialog("Soru metnini giriniz: ");
                    String correctAnswer = JOptionPane.showInputDialog("Sorunun doğru cevabını giriniz: ");
                    int score = Integer.parseInt(JOptionPane.showInputDialog("Sorunun puanını giriniz: "));
                    String difficulty = JOptionPane.showInputDialog("Sorunun zorluk derecesini giriniz: ");
                    ClassicQuestion classicQuestion = new ClassicQuestion(text, correctAnswer, score, difficulty);
                    QuestionsManager.addQuestion(classicQuestion);
                    break;
                case "2":
                    String text1 = JOptionPane.showInputDialog("Soru metnini giriniz: ");
                    String correctAnswer1 = JOptionPane.showInputDialog("Sorunun doğru cevabını giriniz: ");
                    int score1 = Integer.parseInt(JOptionPane.showInputDialog("Sorunun puanını giriniz: "));
                    String difficulty1 = JOptionPane.showInputDialog("Sorunun zorluk derecesini giriniz: ");
                    FillInTheBlankQuestion fillInTheBlankQuestion = new FillInTheBlankQuestion(text1, correctAnswer1, score1, difficulty1);
                    QuestionsManager.addQuestion(fillInTheBlankQuestion);
                    break;
                case "3":
                    String text2 = JOptionPane.showInputDialog("Soru metnini giriniz: ");
                    String correctAnswer2 = JOptionPane.showInputDialog("Sorunun doğru cevabını giriniz: ");
                    int score2 = Integer.parseInt(JOptionPane.showInputDialog("Sorunun puanını giriniz: "));
                    String difficulty2 = JOptionPane.showInputDialog("Sorunun zorluk derecesini giriniz: ");
                    List<String> choices = List.of(JOptionPane.showInputDialog("Sorunun seçeneklerini giriniz: ").split(","));
                    MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion(text2, correctAnswer2, score2, difficulty2, choices);
                    QuestionsManager.addQuestion(multipleChoiceQuestion);
                    break;
                case "4":
                    String text3 = JOptionPane.showInputDialog("Soru metnini giriniz: ");
                    String correctAnswer3 = JOptionPane.showInputDialog("Sorunun doğru cevabını giriniz: ");
                    int score3 = Integer.parseInt(JOptionPane.showInputDialog("Sorunun puanını giriniz: "));
                    String difficulty3 = JOptionPane.showInputDialog("Sorunun zorluk derecesini giriniz: ");
                    TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion(text3, correctAnswer3, score3, difficulty3);
                    QuestionsManager.addQuestion(trueFalseQuestion);
                    break;


                // when user clicks on button2, call the method removeQuestion from QuestionsManager class and remove the question from the question bank
                 button2.addActionListener(e -> {

                    String questionText = JOptionPane.showInputDialog("Silmek istediğiniz sorunun metnini giriniz: ");
                    QuestionsManager.removeQuestion(questionText);
                });


                //when user clicks button3, it should ask the user to choose the type of list. there are 3 types of list. list all questions, list questions by text, list questions by difficulty. according to user's choice call the related method. use listByUserChoice method.
                button3.addActionListener(g -> {
                    String[] options = {"Tüm soruları listele", "Soru metni içinde arama", "Soru şıklarının metinleri içinde arama", "Doğru şıkları üzerinden arama", "Puan üzerinden arama", "Zorluk derecesi üzerinden listeleme"};
                    int choice = JOptionPane.showOptionDialog(null, "Listeleme kriterini seçiniz: ", "Soru Listeleme", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    switch (choice) {
                        case 0:
                            QuestionsManager.listAllQuestions();
                            break;
                        case 1:
                            String questionText = JOptionPane.showInputDialog("Soru metnini giriniz: ");
                            QuestionsManager.listByUserChoice(questionText, 1);
                            break;
                        case 2:
                            String multipleChoiceAnswers = JOptionPane.showInputDialog("Soru şıklarının metnini giriniz: ");
                            QuestionsManager.listByUserChoice(multipleChoiceAnswers, 2);
                            break;
                        case 3:
                            String rightChoices = JOptionPane.showInputDialog("Doğru şıkları giriniz: ");
                            QuestionsManager.listByUserChoice(rightChoices, 3);
                            break;
                        case 4:
                            String questionPoints = JOptionPane.showInputDialog("Puanı giriniz: ");
                            QuestionsManager.listByUserChoice(questionPoints, 4);
                            break;
                        case 5:
                            String questionDifficulty = JOptionPane.showInputDialog("Zorluk derecesini giriniz: ");
                            QuestionsManager.listByUserChoice(questionDifficulty, 5);
                            break;
                    }
                });

                //when user clicks on button4, it should ask the user to choose the type of exam. there are 3 types of exam. test, klasik, karışık. according to user's choice call the related method. use generateExam method and QuestionsManager.questions
                button4.addActionListener(h -> {
                    // Sınav oluşturma işlemleri
                    String[] options = {"Test", "Klasik", "Karışık"};
                    int choice = JOptionPane.showOptionDialog(null, "Sınav türünü seçiniz: ", "Sınav Oluşturma", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    Exam exam;
                            switch (choice) {
                        case 0:
                            // Test sınavı oluşturma ExamGenerator.generateExam(List<Question> questionBank, String examType) methodunu kullanarak
                            exam = ExamGenerator.generateExam(QuestionsManager.getQuestions(), "Test");
                            ExamGenerator.printExam(exam);
                            ExamGenerator.saveExam(exam);
                            break;
                        case 1:
                            // Klasik sınav oluşturma ExamGenerator.generateExam(List<Question> questionBank, String examType) methodunu kullanarak
                            exam = ExamGenerator.generateExam(QuestionsManager.getQuestions(), "Klasik");
                            ExamGenerator.printExam(exam);
                            ExamGenerator.saveExam(exam);
                            break;
                        case 2:
                            // Karışık sınav oluşturma ExamGenerator.generateExam(List<Question> questionBank, String examType) methodunu kullanarak
                            exam = ExamGenerator.generateExam(QuestionsManager.getQuestions(), "Karışık");
                            ExamGenerator.printExam(exam);
                            ExamGenerator.saveExam(exam);
                            break;
                    }
                });

                //when user clicks on button5 program should exit
                button5.addActionListener(j -> System.exit(0));

            }
        });
    }
}



