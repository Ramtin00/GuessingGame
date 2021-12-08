package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Pixelated implements ActionListener {
    ImageIcon happy = new ImageIcon("");
    ImageIcon rebus = new ImageIcon("");
    ImageIcon ape = new ImageIcon("");
    ImageIcon sadSax = new ImageIcon("");
    ImageIcon winner = new ImageIcon("");

    ImageIcon[] questions = { sadSax,happy, rebus,ape };
    String [] answers = { "sad","happy", "rebus","ape" };
    int index;
    int correctGuesses = 0;
    int total_questions = questions.length;
    int second;
    Timer timer;
    int roundNumber = 1;

    JFrame frame = new JFrame();
    JLabel questionLabel = new JLabel();
    JButton submitButton = new JButton("Submit");
    JTextArea inputText = new JTextArea("Type answer here");
    JTextArea rightAnswer = new JTextArea();
    JLabel rounds = new JLabel();
    JButton checkAnswer = new JButton("Check answer");
    JButton playAgain = new JButton("Play Again");
    JLabel timerLabel = new JLabel();
    Font font1 = new Font("Arial", Font.PLAIN,70);


    public Pixelated() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1150);
        frame.setLayout(null);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pictures/backgroundsPic.jpg")))));



        questionLabel.setBounds(185,-50,300,600);
        frame.add(questionLabel, BorderLayout.CENTER);
        //  questionLabel.setIcon(imageBar);

        submitButton.setBounds(300,350,200,25);
        submitButton.setBackground(new Color(59, 89, 182));
        submitButton.setPreferredSize(new Dimension(20,20));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        submitButton.addActionListener(this);

        inputText.setBounds(170,-50,400,400);
        rounds.setBounds(750, 600, 200,200);

        checkAnswer.setBounds(100,350,200,25);
        checkAnswer.setBackground(new Color(59, 89, 182));
        checkAnswer.setPreferredSize(new Dimension(200,200));
        checkAnswer.setForeground(Color.WHITE);
        checkAnswer.setFocusPainted(false);
        checkAnswer.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkAnswer.addActionListener(this);

        second = 0;
        timer();
        timer.start();

        rounds.setText("Round " + (roundNumber));
        frame.add(checkAnswer);
        frame.add(inputText);
        frame.add(submitButton);
        frame.add(rounds);
        frame.add(timerLabel);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        timerLabel.setBounds(170,-50,400,400);
        timerLabel.setFont(font1);



        frame.setVisible(true);
        nextQuestion();
    }


    public void nextQuestion() throws IOException {
        inputText.setText("Type your answer here");
        submitButton.setBackground(new Color(59, 89, 182));;
        checkAnswer.setBackground(new Color(59, 89, 182));
        if(index>=total_questions) {

            results();
            inputText.setVisible(false);
            rounds.setVisible(false);
        }
        else {
            questionLabel.setIcon(questions[index]);
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
    public void results() throws IOException {

        //questionLabel.setIcon(winner);
        timer.stop();
        frame.setIconImage(winner.getImage());
        // timerLabel.setText("Total tid: " + second);
        timerLabel.setText("Total time: ");
        questionLabel.setIcon(null);
        questionLabel.setFont(font1);
        questionLabel.setText(second + " sec");
        // questionLabel.setBounds(0,0,600,800);
        //frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("winner.jpg")))));
        playAgain.setBounds(225,500,200,100);
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


            try {
                new Rebus();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == checkAnswer) {
            if (Objects.equals(inputText.getText(), answers[index])) {
                submitButton.setBackground(new Color(32, 184, 96));
            }
            else {
                submitButton.setBackground(new Color(231, 76, 60));
            }
        }

        if(e.getSource()==submitButton) {
            if(submitButton.getBackground().equals(new Color(231, 76, 60))) {
                JOptionPane.showMessageDialog(null, "Please check your answer");
            }
            if (submitButton.getBackground().equals(new Color(32, 184, 96))) {
                correctGuesses++;
                index++;
                try {
                    nextQuestion();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
                timerLabel.setText("Time: " + second);
            }
        });
    }
}

