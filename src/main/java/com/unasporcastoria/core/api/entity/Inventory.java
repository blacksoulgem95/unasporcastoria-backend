package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "inventories")
@AllArgsConstructor
@RequiredArgsConstructor
public class Inventory extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "label")
  private String label;

  @ManyToOne
  @JoinColumn(name = "character_id")
  private Character owner;

  @Column(name = "is_public")
  private boolean isPublic = false;

  @OneToMany(mappedBy = "inventory", orphanRemoval = true)
  private Set<InventoryEntry> inventoryEntries = new LinkedHashSet<>();
}
