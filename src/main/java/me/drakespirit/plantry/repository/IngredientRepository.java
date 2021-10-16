package me.drakespirit.plantry.repository;

import me.drakespirit.plantry.model.Ingredient;

import java.util.HashSet;
import java.util.Set;

public class IngredientRepository {

    private final Set<Ingredient> ingredients;

    public IngredientRepository() {
        ingredients = new HashSet<>();
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
}
