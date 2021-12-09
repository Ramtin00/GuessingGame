package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdultGame_Version_2 implements ActionListener {

    JPanel mainPanel = new JPanel();

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
    JLabel roundTwoQuestion1 = new JLabel(roundOneQs[0]);
    JLabel roundTwoQuestion2 = new JLabel(roundOneQs[1]);
    JLabel roundTwoQuestion3 = new JLabel(roundOneQs[2]);
    JTextField roundTwoInput = new JTextField("Enter your answer here");

    JPanel roundThreePanel = new JPanel();
    JLabel roundThreeQuestion1 = new JLabel(roundOneQs[0]);
    JLabel roundThreeQuestion2 = new JLabel(roundOneQs[1]);
    JLabel roundThreeQuestion3 = new JLabel(roundOneQs[2]);
    JTextField roundThreeInput = new JTextField("Enter your answer here");

    JButton submit = new JButton("Submit");


    public JPanel getGamePanel() {
        roundOnePanel.setLayout(new BorderLayout());

        question.setText(roundOneQuestion1.getText());

        roundOnePanel.add(question, BorderLayout.NORTH);
        roundOnePanel.add(roundOneInput, BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(roundOnePanel, BorderLayout.NORTH);

        submit.addActionListener(this);
        mainPanel.add(submit, BorderLayout.CENTER);
        return mainPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            roundOne();
        }


    }


    public void roundOne() {
        if (question.getText().equals(roundOneQuestion1.getText())) {
            String answer = roundOneInput.getText();
            if (answer.equals(roundOneAs[0])) {
                roundOnePanel.removeAll();
                question.setText(roundOneQuestion2.getText());
                roundOnePanel.add(question, BorderLayout.NORTH);
                roundOneInput.setText("Enter your answer here");
                roundOnePanel.add(roundOneInput, BorderLayout.CENTER);
                roundOnePanel.revalidate();
                roundOnePanel.repaint();
            }
        } else if (question.getText().equals(roundOneQuestion2.getText())) {
            String answer = roundOneInput.getText();
            if (answer.equals(roundOneAs[1])) {
                roundOnePanel.removeAll();
                question.setText(roundOneQuestion3.getText());
                roundOnePanel.add(question, BorderLayout.NORTH);
                roundOneInput.setText("Enter your answer here");
                roundOnePanel.add(roundOneInput, BorderLayout.CENTER);
                roundOnePanel.revalidate();
                roundOnePanel.repaint();
            }
        }
    }


}
