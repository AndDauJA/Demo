package com.mtb.demo.dto;

import lombok.Builder;

@Builder
public class PriceDto {
    private final int price;

    public int getPrice() {
        return price;
    }
}
