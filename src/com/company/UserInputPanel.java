package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserInputPanel extends JPanel implements ActionListener {
   // private String userName;
  //  private int userAge;


    private JLabel outputLabel = new JLabel("Enter your name and age");
    private JButton okButton = new JButton("Ok");
    private JTextField userNameInput = new JTextField("Name",16);
    private JTextField userAgeInput = new JTextField("Age",16);
    Person p = new Person();

    public UserInputPanel() {
        setBackground(new Color(52, 73, 94 ));
        outputLabel.setForeground(Color.WHITE);
        okButton.setBackground(new Color(59, 89, 182));
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(outputLabel);
        add(userNameInput);
        add(userAgeInput);
        add(okButton);
        okButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     ////   setUserAge(Integer.parseInt(userAgeInput.getText()));
        p.setName(userNameInput.getText());
        p.setAge(Integer.parseInt(userAgeInput.getText()));
        System.out.println(p.toString());

        if (p.age < 13) {
            try {
                JOptionPane.showMessageDialog(null,"Since your age is below 13, let's play the Rebus game!" );
                Rebus rebus = new Rebus();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (p.age <18)
        {

            try {
                JOptionPane.showMessageDialog(null,"Since your age is above 13 and under 18, let's play the Pixelated game!" );
                Pixelated pixelated = new Pixelated();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }


        else {
            removeAll();

            JOptionPane.showMessageDialog(null,"Since your age is above 18, let's play the Questions game!" );
            AdultGame_Version_2 adultGame = new AdultGame_Version_2();
            add(adultGame.getGamePanel());

            revalidate();
            repaint();

            //AdultGame.getAdultGame();
        }
    }

  /*  public void setUserName(String userName) {
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

   */
}
