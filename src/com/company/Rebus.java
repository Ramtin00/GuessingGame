package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Rebus implements ActionListener, Game {
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


    int index;
    int correctGuesses = 0;
    int total_questions = questions.length;
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
    JButton exitButton = new JButton("Exit");
    JButton skipButton = new JButton("Skip");


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
        frame.add(exitButton);
        frame.add(skipButton);

        //Bounds
        questionLabel.setBounds(200,-50,300,600);
        submitButton.setBounds(325,400,200,100);
        inputText.setBounds(225,325,200,25);
        rounds.setBounds(750, 600, 200,200);
        checkAnswer.setBounds(100,400,200,100);
        timerLabel.setBounds(225,-50,400,400);
        hintLabel.setBounds(225,-150,400,400);
        hintButton.setBounds(100,500,200,100);
        exitButton.setBounds(325, 500,200,100);
        skipButton.setBounds(0,300,100,100);

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
        exitButton.addActionListener(this);
        skipButton.addActionListener(this);


        //Metod för nästa fråga
        nextQuestion();

        Person p = new Person();


    }

    @Override
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
    public void leaderboard(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("GuessingGame"));
            bw.write(( + second));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader("GuessingGame"));
            String s;

            while ((s = br.readLine()) != null)
            {
                System.out.println(s);
            }
            br.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
        @Override
    public void results() throws IOException {
        leaderboard();
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
        exitButton.setVisible(false);
        skipButton.setVisible(false);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //if skipbutton pressed, skip question
        if (e.getSource()==skipButton){
            if (index==total_questions-1)
            {
                try {
                    results();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                index++;
                questionLabel.setIcon(questions[index]);
                rightAnswer.setText(answers[index]);
            }

        }

        //If exitbutton pressed exit game
        if (e.getSource() == exitButton){


            if (JOptionPane.showConfirmDialog( frame,"Are you sure you want to exit the game?","Rebus",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                System.exit(0);

        }

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
            if (inputText.getText().trim().equalsIgnoreCase(answers[index])) //Dubbelkolla
            {
                submitButton.setBackground(Color.GREEN);
                submitButton.setOpaque(true);
            }
            else
            {
                submitButton.setBackground(Color.RED);
                submitButton.setOpaque(true);
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

    public void leaderboardSort(){

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

