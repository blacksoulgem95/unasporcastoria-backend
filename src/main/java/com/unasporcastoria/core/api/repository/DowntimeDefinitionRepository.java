package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.DowntimeDefinition;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DowntimeDefinitionRepository extends PagingAndSortingRepository<DowntimeDefinition, Long> {
}