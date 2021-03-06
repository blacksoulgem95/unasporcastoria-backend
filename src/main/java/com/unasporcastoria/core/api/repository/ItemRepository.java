package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
  Page<Item> findByNameContainingIgnoreCase(String name, Pageable pageable);
}