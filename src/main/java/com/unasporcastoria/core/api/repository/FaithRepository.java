package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Faith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaithRepository extends PagingAndSortingRepository<Faith, Long> {
  Page<Faith> findByNameContainingIgnoreCase(String name, Pageable pageable);
}