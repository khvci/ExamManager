package GUI;

import Entities.ClassicQuestion;

import javax.swing.*;

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

        // Butonları paneline ekleme
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        // Paneli frame'e ekleme
        add(panel);

        // Kullanıcı girişi alanı
        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        JTextField input4 = new JTextField();
        panel.add(input1);
        panel.add(input2);
        panel.add(input3);
        panel.add(input4);

        // Butonlara listener ekleme
        button1.addActionListener(e -> QuestionsManager.addQuestion(new ClassicQuestion(input1.getText(), input2.getText(), Integer.parseInt(input3.getText()), input4.getText())));
        button2.addActionListener(e -> QuestionsManager.removeQuestion(input1.getText()));
        button3.addActionListener(e -> QuestionsManager.listByUserChoice(Integer.parseInt(input1.getText()), input2.getText()));
        button4.addActionListener(e -> ExamGenerator.generateExam(input1.getText(), Integer.parseInt(input2.getText())));
        button5.addActionListener(e -> System.exit(0));

        // Frame'i gösterme
        setVisible(true);
    }
}