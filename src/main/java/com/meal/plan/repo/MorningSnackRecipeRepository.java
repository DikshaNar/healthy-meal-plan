package com.meal.plan.repo;

import com.meal.plan.models.MorningSnack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface MorningSnackRecipeRepository extends CrudRepository<MorningSnack, Long> {

    @Query(value = "SELECT * from MORNING_SNACK ms where ms.plan <= :plan",nativeQuery = true)
    List<MorningSnack> findByPlan(Long plan);
}
