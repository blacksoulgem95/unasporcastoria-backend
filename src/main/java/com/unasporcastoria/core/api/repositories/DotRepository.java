package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Dot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotRepository extends CrudRepository<Dot, Long> {
}