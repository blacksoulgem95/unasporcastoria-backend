package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.CharacterAttribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterAttributeRepository extends CrudRepository<CharacterAttribute, Long> {
}