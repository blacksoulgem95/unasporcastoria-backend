package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Faith;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaithRepository extends CrudRepository<Faith, Long> {
}