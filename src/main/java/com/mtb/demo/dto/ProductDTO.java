package com.mtb.demo.dto;


import java.util.Collection;
import java.util.stream.Collectors;
import com.mtb.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@AllArgsConstructor
public class ProductDTO {


	private final String name;
	private final Collection<SizeDto> sizes;
	private final Collection<BrandDto> brandNames;
	private final Collection<ColorDto> colors;
	private final Collection<GenderDto> genders;


	/**
	 * used only for representation in thymeleaf
	 * @return
	 */
	public String toSizesStr() {
		if (this.sizes == null) {
			return "";
		}
		return sizes.stream().
				map(SizeDto::getName)
				.collect(Collectors.joining(", "));
	}
	public String toBrandStr() {
		if (this.brandNames == null) {
			return "";
		}
		return brandNames.stream().
				map(BrandDto::getBrandName)
				.collect(Collectors.joining(", "));
	}
	public String toColorStr() {
		if (this.colors == null) {
			return "";
		}
		return colors.stream().
				map(ColorDto::getColor)
				.collect(Collectors.joining(", "));
	}
	public String toGenderStr() {
		if (this.genders == null) {
			return "";
		}
		return genders.stream()
				.map(GenderDto::getCode)
				.collect(Collectors.joining(", "));
	}
}
