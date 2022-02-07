package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.entity.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends PagingAndSortingRepository<Skill, Long> {
  Page<Skill> findByNameContainingIgnoreCase(String name, Pageable pageable);
}