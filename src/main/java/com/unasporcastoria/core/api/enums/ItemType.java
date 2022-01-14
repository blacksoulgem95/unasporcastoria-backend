package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ItemType {
  TYPE_WEAPON("TYPE_WEAPON"),
  TYPE_ARMOR_SHIELD("TYPE_ARMOR_SHIELD"),
  TYPE_CRAFT_TOOL("TYPE_CRAFT_TOOL"),
  TYPE_ST_TOOL("TYPE_ST_TOOL"),
  TYPE_TRANSPORT("TYPE_TRANSPORT"),
  TYPE_SINGLE_USE("TYPE_SINGLE_USE"),
  TYPE_RESOURCE("TYPE_RESOURCE"),
  TYPE_DRESS("TYPE_DRESS"),
  TYPE_OTHER("TYPE_OTHER");

  @Getter
  @JsonValue
  private final String value;
}
