package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
