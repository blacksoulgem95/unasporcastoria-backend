package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.InventoryEntry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryEntryRepository extends PagingAndSortingRepository<InventoryEntry, Long> {
}