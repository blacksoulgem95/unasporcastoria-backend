package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.SkillCreateDto;
import com.unasporcastoria.core.api.dto.SkillUpdateDto;
import com.unasporcastoria.core.api.entity.Job;
import com.unasporcastoria.core.api.entity.Skill;
import com.unasporcastoria.core.api.exception.Error;
import com.unasporcastoria.core.api.exception.USSException;
import com.unasporcastoria.core.api.repository.SkillRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class SkillService extends BaseService<Skill, Long, SkillRepository> {

  @Autowired
  public SkillService(SkillRepository repository) {
    this.entityName = "Skill";
    this.repository = repository;
  }

  @Transactional
  public Page<Skill> findAll(Pageable pageable, String name) {
    if (StringUtils.isNotBlank(name))
      return repository().findByNameContainingIgnoreCase(name, pageable);
    else return repository().findAll(pageable);
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
