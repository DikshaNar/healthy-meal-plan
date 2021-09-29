package com.meal.plan.service;
import com.meal.plan.models.*;
import com.meal.plan.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MealPlanService {

    @Autowired
    MorningSnackRecipeRepository morningSnackRecipeRepository;

    @Autowired
    BreakfastRecipeRepository breakfastRecipeRepository;

    @Autowired
    LunchRecipeRepository lunchRecipeRepository;

    @Autowired
    NoonSnackRecipeRepository noonSnackRecipeRepository;

    @Autowired
    DinnerRecipeRepository dinnerRecipeRepository;

    @Autowired
    HydrationRecipeRepository hydrationRecipeRepository;

    @Autowired
    KitchenRepo kitchenRepo;

    public  List<String> getAllIngredients() {
        Iterable<Kitchen> list= kitchenRepo.findAll();
        List<String> ingredientsList = new ArrayList<>();
        if(list.iterator().hasNext()){
            list.forEach(kitchen -> {
                if(!kitchen.getIngredient().isEmpty()){
                    ingredientsList.add(kitchen.getIngredient());
                }
            });
        }
        return ingredientsList;
    }
    public ResponseEntity createRecipe(IngredientsAndRecipe ingredientsAndRecipe, String recipeCategory,Long plan) {
        InvalidIngredient invalidIngredient= new InvalidIngredient();
        ingredientsAndRecipe.getIngredients().forEach(ingrdnt-> {
            if(!validateIngredientsFromKitchen(ingrdnt)) {
                invalidIngredient.setInvalidIngredient(ingrdnt);
            }
        });
        if(!invalidIngredient.getInvalidIngredient().isEmpty()) {
            return new ResponseEntity(invalidIngredient, HttpStatus.BAD_REQUEST);
        }
        return createRecipeAsPerCategory(ingredientsAndRecipe,recipeCategory,plan);
    }
    private ResponseEntity createRecipeAsPerCategory(IngredientsAndRecipe ingredientsAndRecipe, String recipeCategory, Long plan) {
        try {
            switch (recipeCategory) {
                case RecipeCategory.MORNING_SNACK:
                    MorningSnack morningSnack = new MorningSnack();
                    morningSnack.setRecipe(ingredientsAndRecipe.getRecipe());
                    morningSnack.setIngredients(ingredientsAndRecipe.getIngredients());
                    morningSnack.setPlan(plan);
                    morningSnack.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    morningSnackRecipeRepository.save(morningSnack);
                    break;
                case RecipeCategory.BREAKFAST:
                    Breakfast breakfast = new Breakfast();
                    breakfast.setIngredients(ingredientsAndRecipe.getIngredients());
                    breakfast.setRecipe(ingredientsAndRecipe.getRecipe());
                    breakfast.setPlan(plan);
                    breakfast.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    breakfastRecipeRepository.save(breakfast);
                    break;
                case RecipeCategory.LUNCH:
                    Lunch lunch = new Lunch();
                    lunch.setIngredients(ingredientsAndRecipe.getIngredients());
                    lunch.setRecipe(ingredientsAndRecipe.getRecipe());
                    lunch.setPlan(plan);
                    lunch.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    lunchRecipeRepository.save(lunch);
                    break;
                case RecipeCategory.AFTERNOON_SNACK:
                    AfternoonSnack afternoonSnack = new AfternoonSnack();
                    afternoonSnack.setIngredients(ingredientsAndRecipe.getIngredients());
                    afternoonSnack.setRecipe(ingredientsAndRecipe.getRecipe());
                    afternoonSnack.setPlan(plan);
                    afternoonSnack.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    noonSnackRecipeRepository.save(afternoonSnack);
                    break;
                case RecipeCategory.DINNER:
                    Dinner dinner = new Dinner();
                    dinner.setIngredients(ingredientsAndRecipe.getIngredients());
                    dinner.setRecipe(ingredientsAndRecipe.getRecipe());
                    dinner.setPlan(plan);
                    dinner.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    dinnerRecipeRepository.save(dinner);
                    break;
                case RecipeCategory.HYDRATION:
                    Hydration hydration = new Hydration();
                    hydration.setIngredients(ingredientsAndRecipe.getIngredients());
                    hydration.setRecipe(ingredientsAndRecipe.getRecipe());
                    hydration.setPlan(plan);
                    hydration.setRecipeName(ingredientsAndRecipe.getRecipeName());
                    hydrationRecipeRepository.save(hydration);
                    break;
                default:
                    return new ResponseEntity("No Category Matched for recipe, Please insert valid category", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity(ingredientsAndRecipe, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity("Unexpected error occurred, "+e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
    private boolean validateIngredientsFromKitchen(String ingredient) {
        return getAllIngredients().stream().anyMatch(e -> e.equalsIgnoreCase(ingredient));

    }

    public MealPlan getMealPlan(Long planId) {
        MealPlan mealPlan =new MealPlan();
        List<Breakfast> breakfast = breakfastRecipeRepository.findByPlan(planId);
        List<MorningSnack> morningSnack = morningSnackRecipeRepository.findByPlan(planId);
        List<Lunch> lunch = lunchRecipeRepository.findByPlan(planId);
        List<AfternoonSnack> afternoonSnack = noonSnackRecipeRepository.findByPlan(planId);
        List<Dinner> dinner = dinnerRecipeRepository.findByPlan(planId);
        List<Hydration> hydration = hydrationRecipeRepository.findByPlan(planId);
        mealPlan.setBreakfastList(breakfast);
        mealPlan.setAfternoonSnackList(afternoonSnack);
        mealPlan.setMorningSnackList(morningSnack);
        mealPlan.setLunchList(lunch);
        mealPlan.setDinnerList(dinner);
        mealPlan.setHydrationList(hydration);
        return mealPlan;
    }

    public ResponseEntity addIngredient(Kitchen ingredient) {
        try {
           kitchenRepo.save(ingredient);
           return new ResponseEntity("Ingredient "+ingredient.getIngredient()+" has added",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity("Something bad happened "+e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
}
