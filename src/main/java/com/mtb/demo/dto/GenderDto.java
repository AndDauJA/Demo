package com.mtb.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Builder

public class GenderDto {
    private final String code;

    public String getCode() {
        return code;
    }
}
