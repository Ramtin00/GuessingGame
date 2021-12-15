package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdultGame implements ActionListener {

    JPanel mainPanel = new JPanel();


    JLabel quizText = new JLabel("Round 1, Question 1");
    JLabel question = new JLabel();

    QuestionsRoundOne roundOne = new QuestionsRoundOne();
    String[] roundOneQs = {roundOne.getQUESTION1(), roundOne.getQUESTION2(), roundOne.getQUESTION3()};
    String[] roundOneAs = {roundOne.getANSWER1(), roundOne.getANSWER2(), roundOne.getANSWER3()};

    QuestionsRoundTwo roundTwo = new QuestionsRoundTwo();
    String[] roundTwoQs = {roundTwo.getQUESTION1(), roundTwo.getQUESTION2(), roundTwo.getQUESTION3()};
    String[] roundTwoAs = {roundTwo.getANSWER1(), roundTwo.getANSWER2(), roundTwo.getANSWER3()};


    QuestionsRoundThree roundThree = new QuestionsRoundThree();
    String[] roundThreeQs = {roundThree.getQUESTION1(), roundThree.getQUESTION2(), roundThree.getQUESTION3()};
    String[] roundThreeAs = {roundThree.getANSWER1(), roundThree.getANSWER2(), roundThree.getANSWER3()};

    JPanel roundOnePanel = new JPanel();
    JLabel roundOneQuestion1 = new JLabel(roundOneQs[0]);
    JLabel roundOneQuestion2 = new JLabel(roundOneQs[1]);
    JLabel roundOneQuestion3 = new JLabel(roundOneQs[2]);
    JTextField roundOneInput = new JTextField("Enter your answer here");

    JPanel roundTwoPanel = new JPanel();
    JLabel roundTwoQuestion1 = new JLabel(roundTwoQs[0]);
    JLabel roundTwoQuestion2 = new JLabel(roundTwoQs[1]);
    JLabel roundTwoQuestion3 = new JLabel(roundTwoQs[2]);
    JTextField roundTwoInput = new JTextField("Enter your answer here");

    JPanel roundThreePanel = new JPanel();
    JLabel roundThreeQuestion1 = new JLabel(roundThreeQs[0]);
    JLabel roundThreeQuestion2 = new JLabel(roundThreeQs[1]);
    JLabel roundThreeQuestion3 = new JLabel(roundThreeQs[2]);
    JTextField roundThreeInput = new JTextField("Enter your answer here");

    JButton submit = new JButton("Submit");


    public JPanel getGamePanel() {
        quizText.setForeground(Color.WHITE);

        roundOnePanel.setLayout(new BorderLayout());
        roundOnePanel.setBackground(new Color(52, 73, 94));

        question.setText(roundOneQuestion1.getText());
        question.setForeground(Color.WHITE);
        roundOnePanel.add(quizText, BorderLayout.NORTH);
        roundOnePanel.add(question, BorderLayout.CENTER);
        roundOnePanel.add(roundOneInput, BorderLayout.SOUTH);

        roundTwoPanel.setBackground(new Color(52, 73, 94));


        roundThreePanel.setBackground(new Color(52, 73, 94));


        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(roundOnePanel, BorderLayout.WEST);

        submit.addActionListener(this);
        submit.setBackground(new Color(59, 89, 182));
        submit.setForeground(Color.WHITE);
        submit.setFocusPainted(false);
        submit.setFont(new Font("Tahoma", Font.BOLD, 12));
        mainPanel.add(submit, BorderLayout.EAST);
        mainPanel.setBackground(new Color(52, 73, 94));
        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            roundOne();
            roundTwo();
            roundThree();
        }

    }

    public void roundOne() {
        if (question.getText().equals(roundOneQuestion1.getText())) {
            String answer = roundOneInput.getText();
            if (answer.trim().equalsIgnoreCase(roundOneAs[0])) {
                roundOnePanel.removeAll();
                question.setText(roundOneQuestion2.getText());
                quizText.setText("Round 1, Question 2");
                roundOnePanel.add(quizText, BorderLayout.NORTH);
                roundOnePanel.add(question, BorderLayout.CENTER);
                roundOneInput.setText("Enter your answer here");
                roundOnePanel.add(roundOneInput, BorderLayout.SOUTH);
                roundOnePanel.revalidate();
                roundOnePanel.repaint();
            }
        } else if (question.getText().equals(roundOneQuestion2.getText())) {
            String answer = roundOneInput.getText();
            if (answer.trim().equalsIgnoreCase(roundOneAs[1])) {
                roundOnePanel.removeAll();
                question.setText(roundOneQuestion3.getText());
                quizText.setText("Round 1, Question 3");
                roundOnePanel.add(quizText, BorderLayout.NORTH);
                roundOnePanel.add(question, BorderLayout.CENTER);
                roundOneInput.setText("Enter your answer here");
                roundOnePanel.add(roundOneInput, BorderLayout.SOUTH);
                roundOnePanel.revalidate();
                roundOnePanel.repaint();
            }
        }


    }

    public void roundTwo() {
        if (question.getText().equals(roundOneQuestion3.getText())) {
            String answer = roundOneInput.getText();
            if (answer.trim().equalsIgnoreCase(roundOneAs[2])) {
                question.setText(roundTwoQuestion1.getText());
                quizText.setText("Round 2, Question 1");
                roundTwoPanel.setLayout(new BorderLayout());
                roundTwoPanel.add(quizText, BorderLayout.NORTH);
                roundTwoPanel.add(question, BorderLayout.CENTER);
                roundTwoInput.setText("Enter your answer here");
                roundTwoPanel.add(roundTwoInput, BorderLayout.SOUTH);
                mainPanel.removeAll();

                mainPanel.setLayout(new BorderLayout());
                mainPanel.add(roundTwoPanel, BorderLayout.NORTH);

                mainPanel.add(submit, BorderLayout.EAST);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        } else if (question.getText().equals(roundTwoQuestion1.getText())) {
            String answer = roundTwoInput.getText();
            if (answer.trim().equalsIgnoreCase(roundTwoAs[0])) {
                question.setText(roundTwoQuestion2.getText());
                quizText.setText("Round 2, Question 2");
                roundTwoPanel.removeAll();
                roundTwoPanel.setLayout(new BorderLayout());
                roundTwoPanel.add(quizText, BorderLayout.NORTH);
                roundTwoPanel.add(question, BorderLayout.CENTER);
                roundTwoInput.setText("Enter your answer here");
                roundTwoPanel.add(roundTwoInput, BorderLayout.SOUTH);
                roundTwoPanel.revalidate();
                roundTwoPanel.repaint();
            }
        } else if (question.getText().equals(roundTwoQuestion2.getText())) {
            String answer = roundTwoInput.getText();
            if (answer.trim().equalsIgnoreCase(roundTwoAs[1])) {
                question.setText(roundTwoQuestion3.getText());
                quizText.setText("Round 2, Question 3");
                roundTwoPanel.removeAll();
                roundTwoPanel.setLayout(new BorderLayout());
                roundTwoPanel.add(quizText, BorderLayout.NORTH);
                roundTwoPanel.add(question, BorderLayout.CENTER);
                roundTwoInput.setText("Enter your answer here");
                roundTwoPanel.add(roundTwoInput, BorderLayout.SOUTH);
                roundTwoPanel.revalidate();
                roundTwoPanel.repaint();
            }
        } else if (question.getText().equals(roundTwoQuestion3.getText())) {
            String answer = roundTwoInput.getText();
            if (answer.trim().equalsIgnoreCase(roundTwoAs[2])) {
                question.setText(roundThreeQuestion1.getText());
                quizText.setText("Round 3, Question 1");
                roundThreePanel.setLayout(new BorderLayout());
                roundThreePanel.add(quizText, BorderLayout.NORTH);
                roundThreePanel.add(question, BorderLayout.CENTER);
                roundThreeInput.setText("Enter your answer here");
                roundThreePanel.add(roundThreeInput, BorderLayout.SOUTH);
                mainPanel.removeAll();
                mainPanel.setLayout(new BorderLayout());
                mainPanel.add(roundThreePanel, BorderLayout.NORTH);
                mainPanel.add(submit, BorderLayout.EAST);
            }
        }

    }

    public void roundThree() {
        if (question.getText().equals(roundThreeQuestion1.getText())) {
            String answer = roundThreeInput.getText();
            if (answer.trim().equalsIgnoreCase(roundThreeAs[0])) {
                question.setText(roundThreeQuestion2.getText());
                quizText.setText("Round 3, Question 2");
                roundThreePanel.removeAll();
                roundThreePanel.setLayout(new BorderLayout());
                roundThreePanel.add(quizText, BorderLayout.NORTH);
                roundThreePanel.add(question, BorderLayout.CENTER);
                roundThreeInput.setText("Enter your answer here");
                roundThreePanel.add(roundThreeInput, BorderLayout.SOUTH);
            }
        } else if (question.getText().equals(roundThreeQuestion2.getText())) {
            String answer = roundThreeInput.getText();
            if (answer.trim().equalsIgnoreCase(roundThreeAs[1])) {
                question.setText(roundThreeQuestion3.getText());
                quizText.setText("Round 3, Question 3");
                roundThreePanel.removeAll();
                roundThreePanel.setLayout(new BorderLayout());
                roundThreePanel.add(quizText, BorderLayout.NORTH);
                roundThreePanel.add(question, BorderLayout.CENTER);
                roundThreeInput.setText("Enter your answer here");
                roundThreePanel.add(roundThreeInput, BorderLayout.SOUTH);
            }
        }
    }
}
