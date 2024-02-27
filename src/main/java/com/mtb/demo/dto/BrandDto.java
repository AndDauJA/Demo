package com.mtb.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder

public class BrandDto {
    private final String brandName;

    public String getBrandName() {
        return brandName;
    }
}
