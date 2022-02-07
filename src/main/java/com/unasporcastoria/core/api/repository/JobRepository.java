package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
  Page<Job> findByNameContainingIgnoreCase(String name, Pageable pageable);
}