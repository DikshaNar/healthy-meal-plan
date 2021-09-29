package com.meal.plan.repo;

import com.meal.plan.models.Dinner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface DinnerRecipeRepository extends CrudRepository<Dinner, Long> {

    @Query(value = "SELECT * from DINNER dinner where dinner.plan <= :plan",nativeQuery = true)
    List<Dinner> findByPlan(Long plan);
}
