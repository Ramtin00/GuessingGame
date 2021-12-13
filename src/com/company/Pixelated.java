package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Pixelated implements ActionListener, Game {
    ImageIcon img = new ImageIcon("src/pictures/monalisa.jpg");
    ImageIcon monaLisa = new ImageIcon(img.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH));

    ImageIcon img2 = new ImageIcon("src/pictures/spiderman.jpg");
    ImageIcon spiderman = new ImageIcon(img2.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));

    ImageIcon img3 = new ImageIcon("src/pictures/leo.jpg");
    ImageIcon leo = new ImageIcon(img3.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH));

    ImageIcon obama = new ImageIcon("src/pictures/obamaPix.png");
    ImageIcon winner = new ImageIcon("src/pictures/winner.jpg");

    ImageIcon[] questions = {
            obama,monaLisa, spiderman,leo

    };
    String [] answers = {
            "obama","mona lisa", "spiderman","leonardo dicaprio"
    };

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
    Font font1 = new Font("Cooper Black", Font.BOLD,65);


    public Pixelated() throws IOException {
        //Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380,650);
        frame.setLayout(null);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pictures/BackgroundPict.jpg")))));
        frame.add(checkAnswer);
        frame.add(inputText);
        frame.add(submitButton);
        frame.add(rounds);
        frame.add(timerLabel);
        frame.setResizable(false);
        frame.add(questionLabel, BorderLayout.CENTER);
        frame.setVisible(true);

        //Bounds
        questionLabel.setBounds(110,-50,300,600);
        submitButton.setBounds(80,500,200,100);
        inputText.setBounds(80,370,200,25);
        rounds.setBounds(750, 600, 200,200);
        checkAnswer.setBounds(80,400,200,100);
        timerLabel.setBounds(70,-120,400,400);
        frame.setLocationRelativeTo(null);

        //Colors
        submitButton.setBackground(new Color(154,214,228));
        submitButton.setForeground(Color.black);
        checkAnswer.setBackground(new Color(154,214,228));
        checkAnswer.setForeground(Color.black);
        playAgain.setBackground(new Color(154,214,228));
        playAgain.setForeground(Color.black);

        //Timer
        second = 0;
        timer();
        timer.start();
        timerLabel.setFont(font1);
        timerLabel.setForeground(new Color(27, 38, 49 ));

        //Actionlisteners
        checkAnswer.addActionListener(this);
        submitButton.addActionListener(this);

        //not Focusable
        checkAnswer.setFocusable(false);
        submitButton.setFocusable(false);
        playAgain.setFocusable(false);

        //Metod för nästa fråga
        nextQuestion();
    }
    @Override
    public void nextQuestion() throws IOException {
        inputText.setText("Type your answer here");
        submitButton.setBackground(new Color(154,214,228));
        checkAnswer.setBackground((new Color(154,214,228)));
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
                submitButton.setForeground(new Color(88, 214, 141));
            }
        });
    }
    @Override
    public void results() throws IOException {
        timer.stop();
        frame.setIconImage(winner.getImage());
        questionLabel.setIcon(null);
        questionLabel.setFont(font1);
        questionLabel.setText(second + "sec");
        playAgain.setBounds(100,500,200,100);

        frame.add(playAgain);
        playAgain.addActionListener(this);
        submitButton.setVisible(false);
        checkAnswer.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //If play again button pressed, play the game again
        if (e.getSource() == playAgain)
        {
            frame.dispose();
            try {
                new Pixelated();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //If check answer button pressed make submit button green, if wrong make it red
        if (e.getSource() == checkAnswer)
        {
            if (inputText.getText().trim().equalsIgnoreCase(answers[index])) //Dubbelkolla
            {
                submitButton.setBackground(new Color(88, 214, 141));
            }
            else
            {
                submitButton.setBackground(new Color(231, 76, 60));
            }
        }
        //If submit button pressed, submit your answer to move on to the next question
        if(e.getSource()==submitButton)
        {
            if(submitButton.getBackground().equals(Color.LIGHT_GRAY))
            {
                JOptionPane.showMessageDialog(null, "Please check your answer");
            }
            if (submitButton.getBackground().equals(new Color(88, 214, 141))) //Dubbelkolla
            {
                correctGuesses++;
                index++;
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
    @Override
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