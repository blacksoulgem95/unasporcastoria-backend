package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.CharacterType;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characters")
@RequiredArgsConstructor
public class Character {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "enabled")
  private boolean enabled;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private CharacterType type;

  @OneToMany(mappedBy = "characterSheet")
  private Set<CharacterAttribute> attributes;

  @OneToMany(mappedBy = "characterSheet")
  private Set<CharacterBackground> backgrounds;

  @OneToMany(mappedBy = "characterSheet")
  private Set<CharacterSkill> skills;

  @ManyToMany
  @JoinTable(
      name = "discarded_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> discardedSkills;

  @ManyToMany
  @JoinTable(
      name = "faction_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> factionSkills;

  @ManyToMany
  @JoinTable(
      name = "job_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> jobSkills;
}
