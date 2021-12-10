package com.unasporcastoria.core.api.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "character_attributes")
@RequiredArgsConstructor
public class CharacterAttribute {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "value")
  private Long value;

  @ManyToOne
  @JoinColumn(name = "attribute_id")
  private Attribute attribute;

  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character characterSheet;
}
