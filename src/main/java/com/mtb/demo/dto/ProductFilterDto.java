package com.mtb.demo.dto;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductFilterDto {



	private final Collection<String> selectedGenderFilter;
	private final Collection<String> selectedBrandNameFilter;
	private final Collection<String> selectedColorFilter;

}
