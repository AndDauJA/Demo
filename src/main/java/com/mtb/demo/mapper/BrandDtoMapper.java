package com.mtb.demo.mapper;

import com.mtb.demo.dto.BrandDto;
import com.mtb.demo.dto.SizeDto;
import com.mtb.demo.entity.Brand;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandDtoMapper {
    public BrandDto mapToBrandDto(Brand brand) {
        return BrandDto.builder()
                .brandName(brand.getName())
                .build();
    }

    public Collection<BrandDto> mapToBrandDtos(Collection<Brand> brands) {
        return brands.stream().map(this::mapToBrandDto).collect(Collectors.toList());
    }


}
