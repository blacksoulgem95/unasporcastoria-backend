package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "character_attributes")
@AllArgsConstructor
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
