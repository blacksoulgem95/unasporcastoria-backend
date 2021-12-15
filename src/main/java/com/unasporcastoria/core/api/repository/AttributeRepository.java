package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Attribute;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends PagingAndSortingRepository<Attribute, Long> {
}