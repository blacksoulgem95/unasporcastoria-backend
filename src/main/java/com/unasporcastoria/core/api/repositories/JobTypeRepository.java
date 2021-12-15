package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.JobType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends CrudRepository<JobType, Long> {
}