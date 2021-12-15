package com.unasporcastoria.core.api.repositories;

import com.unasporcastoria.core.api.entity.Defect;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends CrudRepository<Defect, Long> {
}