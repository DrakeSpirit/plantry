package me.drakespirit.plantry.model;

public record Ingredient(String name) implements Comparable<Ingredient> {

    @Override
    public int compareTo(Ingredient o) {
        return name.compareTo(o.name);
    }

}
