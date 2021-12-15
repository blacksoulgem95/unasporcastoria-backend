package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.SkillGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGroupRepository extends PagingAndSortingRepository<SkillGroup, Long> {
}