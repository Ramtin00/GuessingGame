package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leaderboard implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();



    public Leaderboard() {
        frame.setSize(600, 650);
        frame.setVisible(true);
        frame.add(label);
        label.setBounds(300, 300, 300, 300);

        try {
            BufferedReader br = new BufferedReader(new FileReader("GuessingGame"));
            String s;
            String f = null;
            String tvåa = null;


            while ((s = br.readLine()) != null) {
                // f = s + "\n" + f;

                label.setText(s);



            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        @Override
    public void actionPerformed(ActionEvent e) {

    }
}
