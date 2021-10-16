package me.drakespirit.plantry;

import me.drakespirit.plantry.model.Ingredient;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plantry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);

        JList<Ingredient> ingredients = new JList<>();
        JPanel sidePanel = new JPanel();
        JButton button = new JButton("Add item");
        JLabel title = new JLabel("Pantry");
        frame.getContentPane().add(title, BorderLayout.BEFORE_FIRST_LINE);
        frame.getContentPane().add(ingredients);
        frame.getContentPane().add(sidePanel, BorderLayout.LINE_END);
        sidePanel.add(button);
        frame.setVisible(true);
    }

}
