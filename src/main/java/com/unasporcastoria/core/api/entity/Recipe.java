package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "recipes")
@AllArgsConstructor
@RequiredArgsConstructor
public class Recipe {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Lob
  @Column(name = "description")
  private String description;

  @ManyToOne(targetEntity = DowntimeDefinition.class)
  @JoinColumn(name = "downtime_definition_id")
  private DowntimeDefinition downtimeDefinition;

  @OneToMany(mappedBy = "recipe")
  private Set<Downtime> downtimes = new LinkedHashSet<>();

  @ManyToMany
  @JoinTable(name = "recipes_items",
      joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "items_id"))
  private Set<Item> items = new LinkedHashSet<>();
}
