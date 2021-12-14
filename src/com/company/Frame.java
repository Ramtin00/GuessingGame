package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {
    //Klasser med panelerna vi sak använda

    UserInputPanel userInput = new UserInputPanel();
    JPanel userInputPanel = new JPanel();



    public Frame() throws IOException {
        userInputPanel.setBackground((new Color(52, 73, 94 )));
        userInputPanel.add(userInput);
        add(userInputPanel);

        setSize(new Dimension(600, 130));

        setLocationRelativeTo(null);
        setVisible(true);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        try {
            Frame frame = new Frame();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
