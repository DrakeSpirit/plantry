package me.drakespirit.plantry.service;

import me.drakespirit.plantry.model.Ingredient;
import me.drakespirit.plantry.repository.IngredientRepository;

import java.util.List;
import java.util.Set;

public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService() {
        ingredientRepository = new IngredientRepository();
    }

    public Set<Ingredient> getAllIngredients() {
        return ingredientRepository.getIngredients();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientRepository.addIngredient(ingredient);
    }

    public void removeIngredients(List<Ingredient> ingredients) {
        ingredientRepository.removeIngredients(ingredients);
    }

}
