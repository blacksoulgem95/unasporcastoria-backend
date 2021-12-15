package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Skill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {
}