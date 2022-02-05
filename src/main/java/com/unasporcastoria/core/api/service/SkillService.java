package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.SkillCreateDto;
import com.unasporcastoria.core.api.dto.SkillUpdateDto;
import com.unasporcastoria.core.api.entity.Skill;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
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

  public Skill update(Long id, SkillUpdateDto skill) {
    var s = this.get(id).orElseThrow(this::notFound);

    if (skill.getId().equals(s.getId())) {
      skill.toSkill(s);
    } else {
      throw new USSException(Error.ID_MISMATCH);
    }

    return repository.save(s);
  }
}
