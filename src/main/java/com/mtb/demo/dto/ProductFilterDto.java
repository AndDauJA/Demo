package com.mtb.demo.dto;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;

@Builder

public class ProductFilterDto {
    private final Collection<String> selectedGenderFilter;
    private final Collection<String> selectedBrandNameFilter;
    private final Collection<String> selectedColorFilter;

    public Collection<String> getSelectedGenderFilter() {
        return selectedGenderFilter;
    }

    public Collection<String> getSelectedBrandNameFilter() {
        return selectedBrandNameFilter;
    }

    public Collection<String> getSelectedColorFilter() {
        return selectedColorFilter;
    }


}
