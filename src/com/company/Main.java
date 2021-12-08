package com.company;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {
    private UserInputPanel userInput = new UserInputPanel();

    public Main() {
        setSize(300, 300);
        add(userInput);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
        
    public static void main(String[] args) throws IOException {
        Main main = new Main();
	// This is the development branch
       //Rebus rebus = new Rebus();

        //AdultGame adultGame = new AdultGame();

      //  new Pixelated();


        //Pushed version
    }
}
