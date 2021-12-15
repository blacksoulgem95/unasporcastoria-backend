package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Inventory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Long> {
}