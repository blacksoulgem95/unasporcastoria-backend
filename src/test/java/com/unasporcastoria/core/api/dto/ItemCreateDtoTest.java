package com.unasporcastoria.core.api.dto;

import com.unasporcastoria.core.api.enums.ItemMacroType;
import com.unasporcastoria.core.api.enums.ItemType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ItemCreateDtoTest {

    @Test
    void toItem() {
        var dto = getFullDto();
        var item = dto.toItem();

        assertEquals(dto.getName(), item.getName());
        assertEquals(dto.getDescription(), item.getDescription());
        assertEquals(dto.getPrice(), item.getPrice());
        assertEquals(dto.getSellingPrice(), item.getSellingPrice());
        assertEquals(dto.getValue(), item.getValue());
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
                1L,
                2L,
                3L,
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