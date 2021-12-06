package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame {
    JPanel middlePanel;
    JTextField textField;
    JButton next;
    BufferedImage myPicture;


    Frame(){
        JFrame frame = new JFrame();
        try {
            myPicture = ImageIO.read(new File("src/com/company/obama.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));


        frame.setSize(500,500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        middlePanel = new JPanel();
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100,50));

        next = new JButton("Submit");
        next.setPreferredSize(new Dimension(100,50));
        next.setSize(100,50);
        next.setMaximumSize(new Dimension(100,50));
        next.setBackground(new Color(46, 64, 83));
        next.setForeground(Color.WHITE);
        next.setFocusPainted(false);
        next.setFont(new Font("Tahoma", Font.BOLD, 12));

        middlePanel.add(picLabel);
        middlePanel.add(textField);
        middlePanel.add(next);




        frame.add(middlePanel);
        frame.setVisible(true);
    }
}
