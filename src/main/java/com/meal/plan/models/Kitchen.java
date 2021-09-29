package com.meal.plan.models;
import javax.persistence.*;

@Entity
@Table(name = "Kitchen")
public class Kitchen {

    @Column
    String ingredient;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kitchenId;

    public Long getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(Long kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


}