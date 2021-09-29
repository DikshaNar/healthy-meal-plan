package com.meal.plan.models;
import java.util.ArrayList;
import java.util.List;

public class InvalidIngredient {
    private List<String> invalidIngredient =new ArrayList<>();;
    public List<String> getInvalidIngredient() {
        return invalidIngredient;
    }
    public void setInvalidIngredient(String invalidIngredientName) {
        invalidIngredient.add(invalidIngredientName);
    }

}
