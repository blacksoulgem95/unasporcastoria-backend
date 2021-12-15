package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Background;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends CrudRepository<Background, Long> {
}