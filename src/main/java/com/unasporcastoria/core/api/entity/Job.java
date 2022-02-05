package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "jobs")
@AllArgsConstructor
@RequiredArgsConstructor
public class Job {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Lob
  @Column(name = "description")
  private String description;

  @Lob
  @Column(name = "cite")
  private String cite;

  @Column(name = "can_marry")
  private boolean canMarry;

  @Column(name = "level")
  private Long level;

  @OneToMany(mappedBy = "job")
  private Set<Character> characters = new LinkedHashSet<>();

  @OneToMany(mappedBy = "job")
  private Set<SkillGroup> skillGroups = new LinkedHashSet<>();

  @OneToMany(mappedBy = "job")
  private Set<JobType> requisites = new LinkedHashSet<>();
}
