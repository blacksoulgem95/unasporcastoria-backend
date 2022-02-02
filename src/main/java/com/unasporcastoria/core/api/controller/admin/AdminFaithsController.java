package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.FaithCreateDto;
import com.unasporcastoria.core.api.entity.Faith;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.FaithService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/faiths")
@RequiredArgsConstructor
public class AdminFaithsController {

  private final FaithService faithService;

  @GetMapping
  public Page<Faith> getFaiths(Pageable pageable) {
    return faithService.getFaiths(pageable);
  }

  @GetMapping("/{id}")
  public Faith getFaith(@PathVariable("id") Long id) {
    return faithService.get(id).orElseThrow(() -> new NotFoundException("Faith"));
  }

  @PostMapping
  public Faith createFaith(@RequestBody FaithCreateDto faith) {
    return faithService.createFaith(faith);
  }

  @DeleteMapping("/{id}")
  public void deleteFaith(@PathVariable("id") Long id) {
    faithService.delete(id);
  }

}
