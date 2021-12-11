package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "backgrounds")
@AllArgsConstructor
@RequiredArgsConstructor
public class Background {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "bonus")
  private String bonus;

  @Column(name = "malus")
  private String malus;

  @Column(name = "keep")
  private String keep;

  @Column(name = "extra")
  private String extra;

  @Column(name = "note", columnDefinition = "TEXT")
  private String note;

  @Column(name = "count")
  private Long count;

  @Column(name = "cost_type")
  private Long costType;

  @OneToMany(mappedBy = "background")
  private Set<Dot> backgroundDots;
}
