package me.drakespirit.plantry;

import me.drakespirit.plantry.ui.PantryScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plantry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);

        PantryScreen pantryScreen = new PantryScreen();
        frame.getContentPane().add(pantryScreen.get());
        frame.setVisible(true);
    }

}
