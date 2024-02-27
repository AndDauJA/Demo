package com.mtb.demo.mapper;


import com.mtb.demo.dto.ColorDto;
import com.mtb.demo.entity.Color;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ColorDtoMapper {
    public ColorDto mapToColorDto(Color color) {
        return ColorDto.builder()
                .color(color.getName())
                .build();
    }

    public List<ColorDto> mapToColorDtos(Collection<Color> colors) {
        return colors.stream().map(this::mapToColorDto).collect(Collectors.toList());
    }

}
