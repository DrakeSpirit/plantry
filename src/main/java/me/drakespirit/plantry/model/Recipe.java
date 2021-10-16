package me.drakespirit.plantry.model;

import java.util.List;

public record Recipe(String title, List<Ingredient> ingredients, List<String> steps, List<String> notes) {

}
