package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.FaithCreateDto;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.FaithService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/api/admin/faiths")
@RequiredArgsConstructor
public class AdminFaithsController {

  private final FaithService faithService;

  @GetMapping
  public Page<Faith> getFaiths(Pageable pageable) {
    return faithService.getFaiths(pageable);
  }

  @GetMapping("/{id}")
  public Faith getFaith(@PathVariable("id") Long id) {
    return faithService.getFaith(id).orElseThrow(() -> new NotFoundException("Faith"));
  }

  @PostMapping
  public Faith createFaith(@RequestBody FaithCreateDto faith) {
    return faithService.createFaith(faith);
  }

}
