package com.meal.plan.repo;

import com.meal.plan.models.Kitchen;
import org.springframework.data.repository.CrudRepository;

public interface KitchenRepo extends CrudRepository<Kitchen,Long> {
}
