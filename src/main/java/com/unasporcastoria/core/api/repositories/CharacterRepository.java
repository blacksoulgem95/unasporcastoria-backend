package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {
}