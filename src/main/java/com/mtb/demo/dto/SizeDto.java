package com.mtb.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder

public class SizeDto {
    private final String name;

    public String getName() {
        return name;
    }
}
