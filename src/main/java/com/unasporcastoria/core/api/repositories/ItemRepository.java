package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}