package com.meal.plan.repo;

import com.meal.plan.models.Breakfast;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface BreakfastRecipeRepository extends CrudRepository<Breakfast, Long> {

    @Query(value = "SELECT * from BREAKFAST b where b.plan <= :plan",nativeQuery = true)
    List<Breakfast> findByPlan(@Param("plan")Long plan);
}
