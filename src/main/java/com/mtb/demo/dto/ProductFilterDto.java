package com.mtb.demo.dto;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;


@Builder
public record ProductFilterDto(Collection<String> selectedGenderFilter,
                               Collection<String> selectedBrandNameFilter,
                               Collection<String> selectedColorFilter) {
    public ProductFilterDto(Collection<String> selectedGenderFilter,
                            Collection<String> selectedBrandNameFilter,
                            Collection<String> selectedColorFilter) {
        this.selectedGenderFilter = selectedGenderFilter;
        this.selectedBrandNameFilter = selectedBrandNameFilter;
        this.selectedColorFilter = selectedColorFilter;
    }

}
