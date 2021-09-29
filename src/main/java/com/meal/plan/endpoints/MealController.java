package com.meal.plan.endpoints;
import com.meal.plan.models.IngredientsAndRecipe;
import com.meal.plan.models.Kitchen;
import com.meal.plan.models.MealPlan;
import com.meal.plan.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController
{
    @Autowired
    public MealPlanService service;

    @GetMapping("/getAllIngredients")
    public List<String> getAllIngredients(){
        return service.getAllIngredients();
    }

    @PostMapping("/addIngredients")
    public ResponseEntity addIngredients(@RequestParam("user") String user,@RequestBody Kitchen ingredients){
        if(validateUser(user)){
            return service.addIngredient(ingredients);
        }else{
            return new ResponseEntity<>("Not a Admin",HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(path="/createRecipe",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createRecipe(@RequestParam("user") String user, @RequestParam("plan") Long plan,@RequestParam("category") String recipeCategory, @RequestBody IngredientsAndRecipe ingredientsAndRecipe){
        if(validateUser(user)){
            return service.createRecipe(ingredientsAndRecipe,recipeCategory,plan);
        }else{
            return new ResponseEntity<>("Not a Admin",HttpStatus.FORBIDDEN);
        }
    }
    private boolean validateUser(String user) {
        if(user.equalsIgnoreCase("admin")) {
            return true;
        }
        return false;
    }

    @GetMapping("/getMealPlan")
    public ResponseEntity<Object> getMealPlan(@RequestParam("plan") Long planId ){
        try {
            MealPlan mealPlan = service.getMealPlan(planId);
            return new ResponseEntity<Object>(mealPlan, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<Object>("Unexpected error occurred in database "+e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }
}
