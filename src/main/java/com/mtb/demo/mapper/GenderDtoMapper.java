package com.mtb.demo.mapper;

import com.mtb.demo.dto.GenderDto;
import com.mtb.demo.entity.Gender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenderDtoMapper {
    public GenderDto mapToGenderDto(Gender gender) {
        return GenderDto.builder()
                .code(gender.getCode())
                .build();
    }

    public List<GenderDto> mapToGenderDtos(Collection<Gender> genders) {
        return genders.stream().map(this::mapToGenderDto).collect(Collectors.toList());
    }
}
