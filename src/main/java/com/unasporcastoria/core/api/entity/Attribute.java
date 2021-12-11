package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "attributes")
@AllArgsConstructor
@RequiredArgsConstructor
public class Attribute {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "external_id", unique = true)
  private String externalId;

  @OneToMany(mappedBy = "attribute")
  private Set<Dot> attributeDots;
}
