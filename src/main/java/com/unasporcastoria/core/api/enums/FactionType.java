package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FactionType {
    INVITE_ONLY("INVITE_ONLY"),
    FREE_ENTRY("FREE_ENTRY");

    @Getter
    @JsonValue
    private final String value;
}
