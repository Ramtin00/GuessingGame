package com.company;

import javax.swing.*;

public class Frame extends JFrame {

    JPanel mainPanel = new JPanel();

    //Klasser med panelerna vi sak använda

    UserInputPanel userInput = new UserInputPanel();
    JPanel userInputPanel = new JPanel();


    public Frame() {

        userInputPanel.add(userInput);
        add(userInputPanel);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        Frame frame = new Frame();

    }
}
