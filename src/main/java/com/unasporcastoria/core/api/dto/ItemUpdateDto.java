package com.unasporcastoria.core.api.dto;

import com.unasporcastoria.core.api.enums.ItemMacroType;
import com.unasporcastoria.core.api.enums.ItemType;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ItemUpdateDto implements Serializable {
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
    private final Set<Long> downtimeDefinitionIds;
    private final Set<Long> recipeIds;
}
