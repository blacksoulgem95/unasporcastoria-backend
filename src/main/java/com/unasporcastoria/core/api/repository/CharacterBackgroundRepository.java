package com.unasporcastoria.core.api.repository;

import com.unasporcastoria.core.api.entity.CharacterBackground;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterBackgroundRepository extends PagingAndSortingRepository<CharacterBackground, Long> {
}