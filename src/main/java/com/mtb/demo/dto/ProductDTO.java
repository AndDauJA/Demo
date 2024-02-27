package com.mtb.demo.dto;


import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.mtb.demo.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
public class ProductDTO {

    private final String name;
    private final Collection<SizeDto> sizes;
    private final Collection<BrandDto> brandNames;
    private final Collection<ColorDto> colors;
    private final Collection<GenderDto> genders;

    public String getName() {
        return name;
    }

    public Collection<SizeDto> getSizes() {
        return sizes;
    }

    public Collection<BrandDto> getBrandNames() {
        return brandNames;
    }

    public Collection<ColorDto> getColors() {
        return colors;
    }

    public Collection<GenderDto> getGenders() {
        return genders;
    }

    /**
     * used only for representation in thymeleaf
     *
     * @return
     */
    public static <T> String joinByCommaListNamesOf(Collection<T> list, Function<T, String> mapper) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream()
                .map(mapper)
                .collect(Collectors.joining(", "));
    }

    public String toSizesStr() {
        return joinByCommaListNamesOf(sizes, SizeDto::getName);
    }

    public String toBrandStr() {
        return joinByCommaListNamesOf(brandNames, BrandDto::getBrandName);
    }

    public String toColorStr() {
        return joinByCommaListNamesOf(colors, ColorDto::getColor);
    }

    public String toGenderStr() {
        return joinByCommaListNamesOf(genders, GenderDto::getCode);
    }
}
