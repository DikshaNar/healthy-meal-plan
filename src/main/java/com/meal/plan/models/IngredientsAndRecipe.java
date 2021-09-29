package com.meal.plan.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredientsAndRecipe {

    private List<String> ingredients;
    private List<String> recipe;
    private String recipeName;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }
}
