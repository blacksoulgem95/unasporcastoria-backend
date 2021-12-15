package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.InventoryEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryEntryRepository extends CrudRepository<InventoryEntry, Long> {
}