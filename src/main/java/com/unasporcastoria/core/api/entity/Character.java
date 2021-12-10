package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.CharacterType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "characters")
@AllArgsConstructor
@RequiredArgsConstructor
public class Character {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  @Column(name = "type", nullable = false)
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
      name = "character_discarded_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> discardedSkills;

  @ManyToMany
  @JoinTable(
      name = "character_faction_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> factionSkills;

  @ManyToMany
  @JoinTable(
      name = "character_job_skills",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "skill_id"))
  private Set<Skill> jobSkills;

  @ManyToMany
  @JoinTable(
      name = "character_defects",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "defect_id"))
  private Set<Defect> defects;
}
