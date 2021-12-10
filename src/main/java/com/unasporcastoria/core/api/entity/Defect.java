package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "defects")
@AllArgsConstructor
@RequiredArgsConstructor
public class Defect {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "cost")
  private Long cost;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @ManyToMany(mappedBy = "defects")
  private Set<Character> characters;
}
