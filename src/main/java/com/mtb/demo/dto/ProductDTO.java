package com.mtb.demo.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductDTO {

	private final String name;
	private final Collection<SizeDto> sizes;

	/**
	 * used only for representation in thymeleaf
	 * @return
	 */
	public String toSizesStr() {
		return sizes.stream().
				map(SizeDto::getName)
				.collect(Collectors.joining(", "));
	}
}
