package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ItemMacroType {
  TOOL("TOOL"),
  BUILDING("BUILDING"),
  TERRAIN("TERRAIN");

  @Getter
  @JsonValue
  private final String value;
}
