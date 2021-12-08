package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInputPanel extends JPanel implements ActionListener {
    private String userName;
    private int userAge;

    private JLabel outputLabel = new JLabel("Enter your name and age");
    private JButton okButton = new JButton("Ok");
    private JTextField userNameInput = new JTextField("Name",16);
    private JTextField userAgeInput = new JTextField("Age",16);

    public UserInputPanel() {
        add(outputLabel);
        add(userNameInput);
        add(userAgeInput);
        add(okButton);

        okButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setUserName(userNameInput.getText());
        setUserAge(Integer.parseInt(userAgeInput.getText()));
        if (userAge < 18) {
            try {
                Rebus rebus = new Rebus();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            removeAll();
            AdultGame_Version_2 adultGame = new AdultGame_Version_2();
            add(adultGame.getGamePanel());

            revalidate();
            repaint();

            //AdultGame.getAdultGame();
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }
}
