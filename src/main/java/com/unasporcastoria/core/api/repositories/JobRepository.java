package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
}