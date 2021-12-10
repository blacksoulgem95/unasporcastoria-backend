package com.unasporcastoria.core.api.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "character_skills")
@RequiredArgsConstructor
public class CharacterSkill {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "value")
  private Long value;

  @ManyToOne
  @JoinColumn(name = "skill_id")
  private Skill skill;

  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character characterSheet;
}
