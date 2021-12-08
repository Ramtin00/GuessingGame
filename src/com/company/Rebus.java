package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Rebus implements ActionListener {
    ImageIcon happy = new ImageIcon("src/pictures/happy.png");
    ImageIcon rebus = new ImageIcon("src/pictures/rebus.png");
    ImageIcon ape = new ImageIcon("src/pictures/ape.png");
    ImageIcon sadSax = new ImageIcon("src/pictures/sadSax.png");
    ImageIcon winner = new ImageIcon("src/pictures/winner.jpg");

   ImageIcon[] questions = {
           sadSax,happy, rebus,ape

    };

    String [] answers = {
           "sad","happy", "rebus","ape"
    };

    String [] hints = {
            "s a _", "h _ p _ y", "r e _ _ s", "a _ e"
    };

    String guess;
    String answer;
    int index;
    int correctGuesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;
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
    JLabel timerLabel = new JLabel();
    Font font1 = new Font("Arial", Font.PLAIN,70);
    JButton hintButton = new JButton("Press for hint");
    JLabel hintLabel = new JLabel("");


    public Rebus() throws IOException {
        //Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,650);
        frame.setLayout(null);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pictures/backgroundPicture.jpg")))));
        frame.add(checkAnswer);
        frame.add(inputText);
        frame.add(submitButton);
        frame.add(hintButton);
        frame.add(rounds);
        frame.add(timerLabel);
        frame.setResizable(false);
        frame.add(questionLabel, BorderLayout.CENTER);
        frame.add(hintLabel);
        frame.setVisible(true);

        //Bounds

        questionLabel.setBounds(200,-50,300,600);
        submitButton.setBounds(325,400,200,100);
        inputText.setBounds(225,325,200,25);
        rounds.setBounds(750, 600, 200,200);
        checkAnswer.setBounds(100,400,200,100);
        timerLabel.setBounds(225,-50,400,400);
        hintLabel.setBounds(225,-150,400,400);
        hintButton.setBounds(200,500,200,100);

        //Colors
        hintButton.setBackground(Color.ORANGE);
        submitButton.setBackground(Color.LIGHT_GRAY);
        checkAnswer.setBackground(Color.LIGHT_GRAY);

        //Timer
        second = 0;
        timer();
        timer.start();
        timerLabel.setFont(font1);

        //Hint font
        hintLabel.setFont(font1);

        //Actionlisteners

        hintButton.addActionListener(this);
        checkAnswer.addActionListener(this);
        submitButton.addActionListener(this);

        //Metod för nästa fråga
        nextQuestion();
    }

    public void nextQuestion() throws IOException {
        inputText.setText("Type your answer here");
        submitButton.setBackground(Color.LIGHT_GRAY);
        checkAnswer.setBackground(Color.LIGHT_GRAY);
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
  //  public void displayAnswer()
   {
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                submitButton.setForeground(new Color(25,255,0));
            }
        });
    }
    public void results() throws IOException {
        timer.stop();
        frame.setIconImage(winner.getImage());
        timerLabel.setText("Total time: ");
        questionLabel.setIcon(null);
        questionLabel.setFont(font1);
        questionLabel.setText(second + " sec");
        playAgain.setBounds(225,500,200,100);
        frame.add(playAgain);
        playAgain.addActionListener(this);
        submitButton.setVisible(false);
        checkAnswer.setVisible(false);
        hintButton.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //If hintbutton pressed show hint for right question
        if (e.getSource() == hintButton){
            hintLabel.setText(hints[index]);
        }
        //If play again button pressed, play the game again
        if (e.getSource() == playAgain)
        {
            frame.dispose();
            try {
                new Rebus();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //If check answer button pressed make submit button green, if wrong make it red
        if (e.getSource() == checkAnswer)
        {
            if (inputText.getText().equalsIgnoreCase(answers[index])) //Dubbelkolla
            {
                submitButton.setBackground(Color.GREEN);
            }
            else
            {
                submitButton.setBackground(Color.RED);
            }
        }
        //If submit button pressed, submit your answer to move on to the next question
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
                hintLabel.setText("");
                try {
                    nextQuestion();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                roundNumber = roundNumber+1;
                rounds.setText("Round " + (roundNumber));

            }
        }


    }


    //Timer method
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

