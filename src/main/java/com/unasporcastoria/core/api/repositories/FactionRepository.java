package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Faction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRepository extends CrudRepository<Faction, Long> {
}