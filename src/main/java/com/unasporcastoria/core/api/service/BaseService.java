package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public abstract class BaseService<CL, ID, R extends PagingAndSortingRepository<CL, ID>> {

  protected String entityName;
  protected PagingAndSortingRepository<CL, ID> repository;

  @SuppressWarnings("unchecked")
  protected R repository() {
    return (R) repository;
  }

  public Page<CL> get(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Optional<CL> get(ID id) {
    return repository.findById(id);
  }

  public void delete(ID id) {
    var cl = get(id).orElseThrow(this::notFound);
    repository.delete(cl);
  }

  protected NotFoundException notFound() {
    return new NotFoundException(entityName);
  }
}
