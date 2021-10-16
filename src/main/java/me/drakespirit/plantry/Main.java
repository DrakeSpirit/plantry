package me.drakespirit.plantry;

import me.drakespirit.plantry.service.IngredientService;
import me.drakespirit.plantry.view.PantryScreen;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plantry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,600);

        IngredientService ingredientService = new IngredientService();

        PantryScreen pantryScreen = new PantryScreen(ingredientService);
        frame.getContentPane().add(pantryScreen.get());
        frame.setVisible(true);
    }

}
