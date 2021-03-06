package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.entity.Skill;
import lombok.Data;

import java.io.Serializable;

@Data
public class SkillCreateDto implements Serializable {
  protected String name;
  protected String description1;
  protected String description2;

  @JsonIgnore
  public Skill toSkill() {
    var skill = new Skill();
    skill.setName(name);
    skill.setDescription1(description1);
    skill.setDescription2(description2);
    return skill;
  }
}
