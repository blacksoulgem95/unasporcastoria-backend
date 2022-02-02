package com.unasporcastoria.core.api.controller.admin;

import com.unasporcastoria.core.api.dto.ItemCreateDto;
import com.unasporcastoria.core.api.entity.Item;
import com.unasporcastoria.core.api.exception.NotFoundException;
import com.unasporcastoria.core.api.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin/items")
@RequiredArgsConstructor
public class AdminItemsController {

  private final ItemService itemService;

  @GetMapping
  public Page<Item> getItems(Pageable pageable) {
    return itemService.getItems(pageable);
  }

  @GetMapping("/{id}")
  public Item getItem(@PathVariable("id") Long id) {
    return itemService.get(id).orElseThrow(() -> new NotFoundException("Item"));
  }

  @PostMapping
  public Item createItem(@RequestBody ItemCreateDto item) {
    return itemService.createItem(item);
  }

  @PostMapping("/{id}/image")
  public Item setImage(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) {
    return itemService.setImage(id, file);
  }

  @DeleteMapping("/{id}")
  public void deleteItem(@PathVariable("id") Long id) {
    itemService.delete(id);
  }
}
