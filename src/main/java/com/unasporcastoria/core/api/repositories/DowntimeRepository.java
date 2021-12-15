package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Downtime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DowntimeRepository extends CrudRepository<Downtime, Long> {
}