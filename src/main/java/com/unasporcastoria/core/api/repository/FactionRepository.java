package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Faction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRepository extends PagingAndSortingRepository<Faction, Long> {
}