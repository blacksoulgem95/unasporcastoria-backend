package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.CharacterSkill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSkillRepository extends PagingAndSortingRepository<CharacterSkill, Long> {
}