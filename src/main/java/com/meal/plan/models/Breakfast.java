package com.meal.plan.models;
import com.meal.plan.utils.StringListConverter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BREAKFAST")
public class Breakfast extends IngredientsAndRecipe{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long breakfastId;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String > recipe;

    @Lob
    @Convert(converter = StringListConverter.class)
    private List<String> ingredients;

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
    public Long getBreakfastId() {
        return breakfastId;
    }

    public void setBreakfastId(Long breakfastId) {
        this.breakfastId = breakfastId;
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
