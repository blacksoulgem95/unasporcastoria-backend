package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.SkillGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillGroupRepository extends CrudRepository<SkillGroup, Long> {
}