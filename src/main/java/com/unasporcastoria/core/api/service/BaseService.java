package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.exception.NotFoundException;

public abstract class BaseService {

  protected String entityName;

  protected NotFoundException notFound() {
    return new NotFoundException(entityName);
  }
}
