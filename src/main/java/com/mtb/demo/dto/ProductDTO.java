package com.mtb.demo.dto;


import java.util.Collection;

import com.mtb.demo.utils.JoinListNamesUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ProductDTO {

    private final String name;
    private final Collection<SizeDto> sizes;
    private final Collection<BrandDto> brandNames;
    private final Collection<ColorDto> colors;
    private final Collection<GenderDto> genders;
    private final Collection<PriceDto> price;


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

    public Collection<PriceDto> getPrice() {
        return price;
    }

    /**
     * used only for representation in thymeleaf
     *
     * @return
     */

    public String toSizesStr() {
        return JoinListNamesUtil.joinListNamesOf(sizes, SizeDto::getName);
    }

    public String toBrandStr() {
        return JoinListNamesUtil.joinListNamesOf(brandNames, BrandDto::getBrandName);
    }

    public String toColorStr() {
        return JoinListNamesUtil.joinListNamesOf(colors, ColorDto::getColor);
    }

    public String toGenderStr() {
        return JoinListNamesUtil.joinListNamesOf(genders, GenderDto::getCode);
    }


}
