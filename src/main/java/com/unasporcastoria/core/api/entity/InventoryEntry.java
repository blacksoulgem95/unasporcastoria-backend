package com.unasporcastoria.core.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory_entries")
@AllArgsConstructor
@RequiredArgsConstructor
public class InventoryEntry extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "quantity")
  private Long quantity;

  @Column(name = "struct_point")
  private Long structPoint = 0L;

  // item

  @ManyToOne
  @JoinColumn(name = "inventory_id")
  private Inventory inventory;

  @ManyToOne
  @JoinColumn(name = "downtime_id")
  private Downtime downtime;
}
