package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.DowntimeDefinition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DowntimeDefinitionRepository extends CrudRepository<DowntimeDefinition, Long> {
}