package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    JPanel mainPanel = new JPanel();

    //Klasser med panelerna vi sak använda

    UserInputPanel userInput = new UserInputPanel();
    JPanel userInputPanel = new JPanel();
    Person person = new Person();


    public Frame() {

        userInputPanel.add(userInput);
        add(userInputPanel);






        setSize(new Dimension(600, 200));
        setVisible(true);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        Frame frame = new Frame();

    }
}
