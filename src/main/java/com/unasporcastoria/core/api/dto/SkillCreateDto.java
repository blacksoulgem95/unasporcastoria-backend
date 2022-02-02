package com.unasporcastoria.core.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.entity.Skill;
import lombok.Data;

import java.io.Serializable;

@Data
public class SkillCreateDto implements Serializable {
  private String name;
  private String description1;
  private String description2;
  private Long limitSpouses = 1L;

  @JsonIgnore
  public Skill toSkill() {
    var skill = new Skill();
    skill.setName(name);
    skill.setDescription1(description1);
    skill.setDescription2(description2);
    return skill;
  }
}
