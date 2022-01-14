package com.unasporcastoria.core.api.entity;

import com.unasporcastoria.core.api.enums.ItemMacroType;
import com.unasporcastoria.core.api.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "items")
@AllArgsConstructor
@RequiredArgsConstructor
public class Item extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Lob
  @Column(name = "description")
  private String description;

  @Lob
  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "price")
  private Long price = 0L;

  @Column(name = "selling_price")
  private Long sellingPrice = 0L;

  @Column(name = "value")
  private Long value = 1L;

  @Column(name = "dots")
  private Long dots = 0L;

  @Column(name = "max")
  private Long max = 0L;

  @Column(name = "bonus")
  private Long bonus = 0L;

  @Column(name = "struct_point")
  private Long structPoint = 0L;

  @Enumerated(EnumType.STRING)
  @Column(name = "type")
  private ItemType type;

  @Enumerated(EnumType.STRING)
  @Column(name = "macro_type")
  private ItemMacroType macroType;

  @Column(name = "enabled")
  private boolean enabled = true;

  @Column(name = "is_consumable", nullable = false)
  private boolean isConsumable;

  @Column(name = "only_in_creation")
  private boolean onlyInCreation = true;

  @ManyToMany
  @JoinTable(name = "downtime_definitions_items",
      joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "downtime_definition_id", referencedColumnName = "id"))
  private Set<DowntimeDefinition> downtimeDefinitions = new LinkedHashSet<>();

  @ManyToMany(mappedBy = "items")
  private Set<Recipe> recipes = new LinkedHashSet<>();
}
