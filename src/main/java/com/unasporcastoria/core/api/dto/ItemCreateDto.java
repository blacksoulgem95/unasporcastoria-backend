package com.unasporcastoria.core.api.dto;

import com.unasporcastoria.core.api.entity.Item;
import com.unasporcastoria.core.api.enums.ItemMacroType;
import com.unasporcastoria.core.api.enums.ItemType;
import lombok.Data;

import java.io.Serializable;

@Data
public class ItemCreateDto implements Serializable {
    private final String name;
    private final String description;
    private final Long price;
    private final Long sellingPrice;
    private final Long value;
    private final Long dots;
    private final Long max;
    private final Long bonus;
    private final Long structPoint;
    private final ItemType type;
    private final ItemMacroType macroType;
    private final boolean enabled;
    private final boolean isConsumable;
    private final boolean onlyInCreation;

    public Item toItem() {
        var item = new Item();
        item.setName(this.name);
        item.setDescription(this.description);
        item.setPrice(this.price);
        item.setSellingPrice(this.sellingPrice);
        item.setValue(this.value);
        item.setDots(this.dots);
        item.setMax(this.max);
        item.setBonus(this.bonus);
        item.setStructPoint(this.structPoint);
        item.setType(this.type);
        item.setMacroType(this.macroType);
        item.setEnabled(this.enabled);
        item.setConsumable(this.isConsumable);
        item.setOnlyInCreation(this.onlyInCreation);
        return item;
    }
}
