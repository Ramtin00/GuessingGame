package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInputPanel extends JPanel implements ActionListener {
    private JLabel outputLabel = new JLabel("Enter your name and age");
    private JButton okButton = new JButton("Ok");
    private JTextField userNameInput = new JTextField("Name", 16);
    private JTextField userAgeInput = new JTextField("Age", 16);
    SingletonPerson singletonPerson = SingletonPerson.getInstance();

    public UserInputPanel() {
        add(outputLabel);
        add(userNameInput);
        add(userAgeInput);
        add(okButton);
        okButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        singletonPerson.setAge(Integer.parseInt(userAgeInput.getText()));
        singletonPerson.setName(userNameInput.getText());

        if (singletonPerson.getAge() < 13) {
            try {
                JOptionPane.showMessageDialog(null, "Since your age is below 13, let's play the Rebus game!");
                Rebus rebus = new Rebus();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (singletonPerson.getAge() < 18) {
            try {
                JOptionPane.showMessageDialog(null, "Since your age is below 18, let's play the pixelated game!");
                Pixelated pixelated = new Pixelated();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Since your age is above 18, let's play the questions game!");
            removeAll();
            AdultGame adultGame = new AdultGame();
            add(adultGame.getGamePanel());
            revalidate();
            repaint();
        }
    }
}