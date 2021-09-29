package com.meal.plan.models;

import com.meal.plan.utils.StringListConverter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DINNER")
public class Dinner extends IngredientsAndRecipe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dinnerId;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String > recipe;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> ingredients;

    @Column(name = "PLAN")
    private Long plan;

    public Long getPlan() {
        return plan;
    }

    @Column
    private String recipeName;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public void setPlan(Long plan) {
        this.plan = plan;
    }

    public Long getDinnerId() {
        return dinnerId;
    }

    public void setDinnerId(Long dinnerId) {
        this.dinnerId = dinnerId;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


}
