package com.mtb.demo.dto;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductFilterDto {
    private final Collection<String> selectedGenderFilter;
    private final Collection<String> selectedBrandNameFilter;
    private final Collection<String> selectedColorFilter;


}
