package com.mtb.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ColorDto {
    private final String color;

    public String getColor() {
        return color;
    }
}
