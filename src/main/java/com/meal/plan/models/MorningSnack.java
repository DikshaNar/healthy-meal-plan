package com.meal.plan.models;


import com.meal.plan.utils.StringListConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "MORNING_SNACK")
public class MorningSnack extends IngredientsAndRecipe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long morningSnackId;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> ingredients;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> recipe;


    @Column(name = "PLAN")
    private Long plan;

    @Column
    private String recipeName;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public Long getPlan() {
        return plan;
    }

    public void setPlan(Long plan) {
        this.plan = plan;
    }

    public Long getMorningSnackId() {
        return morningSnackId;
    }

    public void setMorningSnackId(Long morningSnackId) {
        this.morningSnackId = morningSnackId;
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
