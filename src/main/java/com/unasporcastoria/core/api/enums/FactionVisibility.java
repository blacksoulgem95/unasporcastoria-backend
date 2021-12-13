package com.unasporcastoria.core.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum FactionVisibility {
    PUBLIC("PUBLIC"),
    SECRET("SECRET");

    @Getter
    @JsonValue
    private final String value;
}
