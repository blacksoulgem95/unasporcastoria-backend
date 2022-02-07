package com.unasporcastoria.core.api.controller.user;

import com.unasporcastoria.core.api.entity.Item;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/items")
@RequiredArgsConstructor
public class ItemsController {

  // TOOD user specific item API

  private final ItemService itemService;

  @GetMapping
  public Page<Item> getItems(@RequestParam(value = "name", required = false) String name,
                             Pageable pageable) {
    return itemService.findAll(pageable, name);
  }

  @GetMapping("/{id}")
  public Item getItem(@PathVariable("id") Long id) {
    return itemService.get(id).orElseThrow(() -> new NotFoundException("Item"));
  }

}
