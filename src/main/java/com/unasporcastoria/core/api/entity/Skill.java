package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "skills")
@AllArgsConstructor
@RequiredArgsConstructor
public class Skill {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description_1", columnDefinition = "TEXT")
  private String description1;

  @Column(name = "description_2", columnDefinition = "TEXT")
  private String description2;

  @OneToMany(mappedBy = "skill")
  private List<Dot> skillDots;

}

