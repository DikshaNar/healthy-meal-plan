package com.meal.plan.repo;

import com.meal.plan.models.AfternoonSnack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface NoonSnackRecipeRepository extends CrudRepository<AfternoonSnack, Long> {

    @Query(value = "SELECT * from NOON_SNACK ns where ns.plan <= :plan",nativeQuery = true)
    List<AfternoonSnack> findByPlan(Long plan);
}
