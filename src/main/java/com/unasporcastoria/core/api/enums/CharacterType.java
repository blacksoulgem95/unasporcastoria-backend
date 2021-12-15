package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CharacterType {
    PC("PC"),
    NPC("NPC");

    @Getter
    @JsonValue
    private final String value;
}
