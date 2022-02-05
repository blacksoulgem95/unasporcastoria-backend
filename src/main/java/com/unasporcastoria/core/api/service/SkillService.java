package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.SkillCreateDto;
import com.unasporcastoria.core.api.entity.Skill;
import com.unasporcastoria.core.api.repository.SkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SkillService extends BaseService<Skill, Long> {

  @Autowired
  public SkillService(SkillRepository repository) {
    this.entityName = "Skill";
    this.repository = repository;
  }

  public Page<Skill> getSkills(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Skill createSkill(SkillCreateDto skillDto) {
    var skill = skillDto.toSkill();
    return repository.save(skill);
  }

}