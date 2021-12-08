package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AdultGame implements ActionListener {






    ImageIcon winner = new ImageIcon("winner.jpg");




    /*String[] questions = {
            "Vad heter jag","Hur gammal är jag"

    };*/

    QuestionsRoundOne roundOne = new QuestionsRoundOne();
    String[] questions = {roundOne.getQUESTION1(), roundOne.getQUESTION2(), roundOne.getQUESTION3()};

    /*String [] answers = {
            "Niklas","25"
    };*/
    String[] answers = {roundOne.getANSWER1(), roundOne.getANSWER2(), roundOne.getANSWER3()};

    int index;
    int correctGuesses = 0;
    int total_questions = questions.length;
    int second;
    Timer timer;

    int roundNumber = 1;



    JFrame frame = new JFrame();
    JLabel questionLabel = new JLabel();
    JLabel timerLabel = new JLabel();
    JLabel secondsLeft = new JLabel();
    JTextField numberRight = new JTextField();
    JButton submitButton = new JButton("Submit");
    JTextArea inputText = new JTextArea("Type answer here");
    JTextArea rightAnswer = new JTextArea();
    JLabel rounds = new JLabel();
    JButton checkAnswer = new JButton("Check answer");
    JButton playAgain = new JButton("Play Again");
    Font font1 = new Font("", Font.BOLD,40);









    public AdultGame() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/pictures/backgroundAdultGame.jpg")))));
        frame.add(timerLabel);
        timerLabel.setBounds(225,-50,400,400);


        questionLabel.setBounds(200,-50,500,600);
        frame.add(questionLabel, BorderLayout.CENTER);
        questionLabel.setFont(font1);
        questionLabel.setForeground(Color.BLACK);
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

        timer();
        timer.start();



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


            try {
                new AdultGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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

