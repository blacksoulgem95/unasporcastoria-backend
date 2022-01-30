package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.FaithCreateDto;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.repository.FaithRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FaithService extends BaseService {

  private final FaithRepository faithRepository;

  {
    this.entityName = "Faith";
  }

  public Page<Faith> getFaiths(Pageable pageable) {
    return faithRepository.findAll(pageable);
  }

  public Optional<Faith> getFaith(Long id) {
    return faithRepository.findById(id);
  }

  public Faith createFaith(FaithCreateDto faithDto) {
    var faith = faithDto.toFaith();
    return faithRepository.save(faith);
  }

}
