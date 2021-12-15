package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.CharacterSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterSkillRepository extends CrudRepository<CharacterSkill, Long> {
}