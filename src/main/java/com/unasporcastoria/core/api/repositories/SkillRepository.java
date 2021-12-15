package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {
}