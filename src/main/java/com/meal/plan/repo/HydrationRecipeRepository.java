package com.meal.plan.repo;
import com.meal.plan.models.Hydration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface HydrationRecipeRepository extends CrudRepository<Hydration, Long> {

 @Query(value = "SELECT * from HYDRATION h where h.plan <= :plan",nativeQuery = true)
 List<Hydration> findByPlan(Long plan);
}
