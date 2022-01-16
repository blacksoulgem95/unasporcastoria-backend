package com.unasporcastoria.core.api.dto;

import com.unasporcastoria.core.api.enums.ItemMacroType;
import com.unasporcastoria.core.api.enums.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ItemCreateDtoTest {

  @Test
  void toItem() {
    var dto = getFullDto();
    var item = dto.toItem();

    assertEquals(dto.getName(), item.getName());
    assertEquals(dto.getDescription(), item.getDescription());
    assertEquals(dto.getPrice(), (double) item.getPrice() / 10);
    assertEquals(dto.getSellingPrice(), (double) item.getSellingPrice() / 10);
    assertEquals(dto.getValue(), (double) item.getValue() / 10);
    assertEquals(dto.getDots(), item.getDots());
    assertEquals(dto.getMax(), item.getMax());
    assertEquals(dto.getBonus(), item.getBonus());
    assertEquals(dto.getStructPoint(), item.getStructPoint());
    assertEquals(dto.getType(), item.getType());
    assertEquals(dto.getMacroType(), item.getMacroType());
    assertEquals(dto.isEnabled(), item.isEnabled());
    assertEquals(dto.isConsumable(), item.isConsumable());
    assertEquals(dto.isOnlyInCreation(), item.isOnlyInCreation());
  }

  private ItemCreateDto getFullDto() {
    return new ItemCreateDto(
        "Ajeje",
        "Brazorf",
        0.1,
        0.2,
        0.3,
        4L,
        5L,
        6L,
        7L,
        ItemType.TYPE_ARMOR_SHIELD,
        ItemMacroType.BUILDING,
        true,
        false,
        true
    );
  }
}