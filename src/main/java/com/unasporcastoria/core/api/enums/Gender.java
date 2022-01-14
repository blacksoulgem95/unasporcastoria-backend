package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender {
  MAN("MAN"),
  WOMAN("WOMAN");

  @Getter
  @JsonValue
  private final String value;

}
