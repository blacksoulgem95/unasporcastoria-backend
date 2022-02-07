package com.unasporcastoria.core.api.service;

import com.unasporcastoria.core.api.dto.ItemCreateDto;
import com.unasporcastoria.core.api.entity.Item;
import com.unasporcastoria.core.api.exception.WrongFileTypeException;
import com.unasporcastoria.core.api.repository.FaithRepository;
import com.unasporcastoria.core.api.repository.ItemRepository;
import com.unasporcastoria.core.api.service.storage.FirebaseStorageService;
import com.unasporcastoria.core.api.util.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class ItemService extends BaseService<Item, Long, ItemRepository> {

  private final FirebaseStorageService storage;

  @Autowired
  public ItemService(ItemRepository repository, FirebaseStorageService storage) {
    this.entityName = "Item";
    this.repository = repository;
    this.storage = storage;
  }

  public Page<Item> getItems(Pageable pageable) {
    return repository.findAll(pageable);
  }
  
  public Item createItem(ItemCreateDto itemDto) {
    var item = itemDto.toItem();
    return repository.save(item);
  }

  public Item setImage(Long id, MultipartFile file) {
    var item = this.get(id).orElseThrow(this::notFound);

    if (!FileUtils.isImage(Objects.requireNonNull(file.getContentType()))) {
      log.warn("Tried to upload the wrong type of file, expected Image, got {}", file.getContentType());
      throw new WrongFileTypeException("Images", file.getContentType());
    }

    if (StringUtils.isNotEmpty(item.getImageUrl())) {
      storage.deleteImageFromUrl(item.getImageUrl());
    }

    var fileUrl = storage.upload("images/items/", "item_" + item.getId(), file);

    item.setImageUrl(fileUrl);

    return repository.save(item);
  }

}
