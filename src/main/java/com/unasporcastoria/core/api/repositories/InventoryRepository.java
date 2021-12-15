package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
}