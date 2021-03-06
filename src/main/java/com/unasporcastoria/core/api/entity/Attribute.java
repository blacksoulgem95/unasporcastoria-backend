package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "attributes")
@AllArgsConstructor
@RequiredArgsConstructor
public class Attribute extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Lob
  @Column(name = "description")
  private String description;

  @Column(name = "external_id", unique = true)
  private String externalId;

  @OneToMany(mappedBy = "attribute")
  private Set<Dot> attributeDots = new LinkedHashSet<>();

  @OneToMany(mappedBy = "attribute")
  private Set<DowntimeDefinition> downtimeDefinitions = new LinkedHashSet<>();
}
