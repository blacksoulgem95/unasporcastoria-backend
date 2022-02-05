package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Skill;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class SkillUpdateDto extends SkillCreateDto {
  protected Long id;

  @JsonIgnore
  public void toSkill(Skill skill) {
    skill.setName(name);
    skill.setDescription1(description1);
    skill.setDescription2(description2);
  }
}
