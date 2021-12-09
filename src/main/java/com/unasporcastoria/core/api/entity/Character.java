package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.CharacterType;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "character")
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
}
