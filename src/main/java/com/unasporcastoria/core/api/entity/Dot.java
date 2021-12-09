package com.unasporcastoria.core.api.entity;


import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "dot")
@RequiredArgsConstructor
public class Dot {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "effect")
  private String effect;

  @Column(name = "value")
  private Double value;

  @ManyToOne
  @JoinColumn(name = "attribute_id")
  private Attribute attribute;

  @ManyToOne
  @JoinColumn(name = "background_id")
  private Background background;

  @ManyToOne
  @JoinColumn(name = "skill_id")
  private Skill skill;

}
