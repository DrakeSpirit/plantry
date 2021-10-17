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
    private final JList<Ingredient> ingredientsList;
    private final JButton addItemButton;
    private final JButton removeItemButton;

    private final IngredientService ingredientService;

    public PantryScreen(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
        mainPanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Pantry");
        mainPanel.add(title, BorderLayout.PAGE_START);

        DefaultListModel<Ingredient> ingredientListModel = new DefaultListModel<>();
        ingredientsList = new JList<>(ingredientListModel);
        mainPanel.add(ingredientsList, BorderLayout.CENTER);

        addItemButton = new JButton("Add item");
        addItemButton.addActionListener(this);
        removeItemButton = new JButton("Remove item");
        removeItemButton.addActionListener(this);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.add(addItemButton);
        sidePanel.add(removeItemButton);
        mainPanel.add(sidePanel, BorderLayout.LINE_END);
    }

    public JPanel get() {
        return mainPanel;
    }

    public void updateIngredientList() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients().stream()
                .sorted()
                .collect(toList());
        DefaultListModel<Ingredient> ingredientsListModel = (DefaultListModel<Ingredient>) ingredientsList.getModel();
        ingredientsListModel.clear();
        ingredientsListModel.addAll(ingredients);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addItemButton) {
            onClickAddItemButton();
        }
        else if(e.getSource() == removeItemButton) {
            onClickRemoveItemButton();
        }
    }

    private void onClickAddItemButton() {
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

    private void onClickRemoveItemButton() {
        List<Ingredient> selectedIngredients = ingredientsList.getSelectedValuesList();
        ingredientService.removeIngredients(selectedIngredients);
        updateIngredientList();
    }

}
