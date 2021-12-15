package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.Character;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends PagingAndSortingRepository<Character, Long> {
}