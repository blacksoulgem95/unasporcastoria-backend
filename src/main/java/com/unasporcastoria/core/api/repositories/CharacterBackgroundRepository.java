package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.CharacterBackground;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterBackgroundRepository extends CrudRepository<CharacterBackground, Long> {
}