package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.JobType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends PagingAndSortingRepository<JobType, Long> {
}