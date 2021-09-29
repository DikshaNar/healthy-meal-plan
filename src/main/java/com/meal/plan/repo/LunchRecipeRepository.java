package com.meal.plan.repo;
import com.meal.plan.models.Lunch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface LunchRecipeRepository extends CrudRepository<Lunch, Long> {

    @Query(value = "SELECT * from LUNCH lunch where lunch.plan <= :plan",nativeQuery = true)
    List<Lunch> findByPlan(Long plan);
}
