package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AdultGame implements ActionListener {
    ImageIcon winner = new ImageIcon("winner.jpg");
    String[] questions = {
            "Vad heter jag","Hur gammal är jag"
    };

    String [] answers = {
            "Niklas","25"
    };

    String guess;
    String answer;
    int index;
    int correctGuesses = 0;
    int total_questions = questions.length;
    int result;
    int second;
    Timer timer;
    int roundNumber = 1;

    JFrame frame = new JFrame();
    JLabel questionLabel = new JLabel();
    JLabel timeLabel = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JButton submitButton = new JButton("Submit");
    JTextArea inputText = new JTextArea("Type answer here");
    JTextArea rightAnswer = new JTextArea();
    JLabel rounds = new JLabel();
    JButton checkAnswer = new JButton("Check answer");
    JButton playAgain = new JButton("Play Again");
    Font font1 = new Font("Arial", Font.PLAIN,40);


    public AdultGame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);

        questionLabel.setBounds(200,-50,500,600);
        frame.add(questionLabel, BorderLayout.CENTER);
        questionLabel.setFont(font1);
        //  questionLabel.setIcon(imageBar);
        submitButton.setBounds(325,400,200,100);
        inputText.setBounds(225,325,200,25);
        rounds.setBounds(750, 600, 200,200);
        checkAnswer.setBounds(100,400,200,100);
        checkAnswer.addActionListener(this);
        submitButton.setBackground(Color.LIGHT_GRAY);
        checkAnswer.setBackground(Color.LIGHT_GRAY);

        rounds.setText("Round " + (roundNumber));
        frame.add(checkAnswer);
        frame.add(inputText);
        frame.add(submitButton);
        frame.add(rounds);

        submitButton.addActionListener(this);



        frame.setVisible(true);
        nextQuestion();
    }


    public void nextQuestion(){
        inputText.setText("Type your answer here");
        submitButton.setBackground(Color.LIGHT_GRAY);
        checkAnswer.setBackground(Color.LIGHT_GRAY);
        if(index>=total_questions) {

            results();
            inputText.setVisible(false);
            rounds.setVisible(false);
        }
        else {
            questionLabel.setText(questions[index]);
            rightAnswer.setText(answers[index]);


        }



    }
    public void displayAnswer(){
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                submitButton.setForeground(new Color(25,255,0));


            }
        });


    }
    public void results(){

        questionLabel.setText("");
        questionLabel.setIcon(winner);
        playAgain.setBounds(450,800,200,100);
        frame.add(playAgain);
        playAgain.addActionListener(this);
        submitButton.setVisible(false);
        checkAnswer.setVisible(false);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain)
        {
            frame.dispose();


            new AdultGame();
        }

        if (e.getSource() == checkAnswer)
        {
            if (Objects.equals(inputText.getText(), answers[index])) //Dubbelkolla
            {

                // submitButton.setForeground(Color.GREEN);
                submitButton.setBackground(Color.GREEN);


            }
            else
            {
                submitButton.setBackground(Color.RED);
            }
        }

        if(e.getSource()==submitButton)
        {
            if(submitButton.getBackground().equals(Color.LIGHT_GRAY))
            {
                JOptionPane.showMessageDialog(null, "Please check your answer");
            }
            if (submitButton.getBackground().equals(Color.GREEN)) //Dubbelkolla
            {


                correctGuesses++;
                index++;



                nextQuestion();
                roundNumber = roundNumber+1;

                rounds.setText("Round " + (roundNumber));
                displayAnswer();

            }

        }
        displayAnswer();
    }
    public void timer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                //timerLabel.setText("Time: " + second);
            }
        });
    }
}

