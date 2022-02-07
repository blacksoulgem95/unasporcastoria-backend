package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.FaithCreateDto;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.repository.FaithRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class FaithService extends BaseService<Faith, Long, FaithRepository> {

  @Autowired
  public FaithService(FaithRepository repository) {
    this.entityName = "Faith";
    this.repository = repository;
  }

  public Page<Faith> getFaiths(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Faith createFaith(FaithCreateDto faithDto) {
    var faith = faithDto.toFaith();
    return repository.save(faith);
  }

}
