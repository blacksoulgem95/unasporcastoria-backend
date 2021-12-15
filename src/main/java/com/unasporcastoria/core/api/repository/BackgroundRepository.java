package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Background;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends PagingAndSortingRepository<Background, Long> {
}