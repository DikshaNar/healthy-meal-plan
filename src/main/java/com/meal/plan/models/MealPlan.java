package com.meal.plan.models;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MealPlan {

    private List<Breakfast> breakfastList;
    private List<MorningSnack> morningSnackList;
    private List<AfternoonSnack> afternoonSnackList;
    private List<Lunch> lunchList;
    private List<Dinner> dinnerList;
    private List<Hydration> hydrationList;

    public List<Breakfast> getBreakfastList() {
        return breakfastList;
    }

    public void setBreakfastList(List<Breakfast> breakfastList) {
        this.breakfastList = breakfastList;
    }

    public List<MorningSnack> getMorningSnackList() {
        return morningSnackList;
    }

    public void setMorningSnackList(List<MorningSnack> morningSnackList) {
        this.morningSnackList = morningSnackList;
    }

    public List<AfternoonSnack> getAfternoonSnackList() {
        return afternoonSnackList;
    }

    public void setAfternoonSnackList(List<AfternoonSnack> afternoonSnackList) {
        this.afternoonSnackList = afternoonSnackList;
    }

    public List<Lunch> getLunchList() {
        return lunchList;
    }

    public void setLunchList(List<Lunch> lunchList) {
        this.lunchList = lunchList;
    }

    public List<Dinner> getDinnerList() {
        return dinnerList;
    }

    public void setDinnerList(List<Dinner> dinnerList) {
        this.dinnerList = dinnerList;
    }

    public List<Hydration> getHydrationList() {
        return hydrationList;
    }

    public void setHydrationList(List<Hydration> hydrationList) {
        this.hydrationList = hydrationList;
    }

}
