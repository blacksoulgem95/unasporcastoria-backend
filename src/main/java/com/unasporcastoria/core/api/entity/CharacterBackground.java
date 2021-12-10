package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "character_backgrounds")
@AllArgsConstructor
@RequiredArgsConstructor
public class CharacterBackground {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "value")
  private Long value;

  @ManyToOne
  @JoinColumn(name = "background_id")
  private Background background;

  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character characterSheet;
}
