package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Attribute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends CrudRepository<Attribute, Long> {
}