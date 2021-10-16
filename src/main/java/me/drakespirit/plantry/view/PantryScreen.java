package me.drakespirit.plantry.view;

import me.drakespirit.plantry.model.Ingredient;
import me.drakespirit.plantry.service.IngredientService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PantryScreen implements ActionListener {

    private final JPanel mainPanel;
    private final DefaultListModel<Ingredient> ingredientListModel;
    private final IngredientService ingredientService;

    public PantryScreen(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
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

    public void updateIngredientList() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients().stream()
                .sorted()
                .collect(toList());
        ingredientListModel.clear();
        ingredientListModel.addAll(ingredients);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ingredientName = (String) JOptionPane.showInputDialog(
                mainPanel,
                "Ingredient name:",
                "Add an ingredient",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

        if((ingredientName != null) && (ingredientName.length() > 0)) {
            Ingredient ingredient = new Ingredient(ingredientName);
            ingredientService.addIngredient(ingredient);
            updateIngredientList();
        }
    }

}
