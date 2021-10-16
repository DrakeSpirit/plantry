package me.drakespirit.plantry.ui;

import me.drakespirit.plantry.model.Ingredient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantryScreen implements ActionListener {

    private final JPanel mainPanel;
    private final DefaultListModel<Ingredient> ingredientListModel;

    public PantryScreen() {
        mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Pantry");
        mainPanel.add(title, BorderLayout.PAGE_START);

        ingredientListModel = new DefaultListModel<>();
        JList<Ingredient> ingredients = new JList<>(ingredientListModel);
        mainPanel.add(ingredients, BorderLayout.CENTER);

        JButton addItemButton = new JButton("Add item");
        addItemButton.addActionListener(this);
        JPanel sidePanel = new JPanel(new BorderLayout());
        sidePanel.add(addItemButton, BorderLayout.PAGE_START);
        mainPanel.add(sidePanel, BorderLayout.LINE_END);
    }

    public JPanel get() {
        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ingredient testIngredient = new Ingredient("test item");
        ingredientListModel.addElement(testIngredient);
    }

}
