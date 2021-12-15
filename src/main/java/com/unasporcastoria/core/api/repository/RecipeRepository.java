package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Recipe;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends PagingAndSortingRepository<Recipe, Long> {
}