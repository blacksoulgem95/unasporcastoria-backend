package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Defect;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends PagingAndSortingRepository<Defect, Long> {
}