package com.mtb.demo.mapper;


import com.mtb.demo.dto.ColorDto;
import com.mtb.demo.entity.Color;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class ColorDtoMapper {
    public ColorDto mapToColorDto(Color color) {
        return ColorDto.builder()
                .color(color.getName())
                .build();
    }

    public List<ColorDto> mapToColorDtos(Collection<Color> colors) {
        List<ColorDto> list = new ArrayList<>();
        for (Color color : colors) {
            ColorDto colorDto = mapToColorDto(color);
            list.add(colorDto);
        }
        return list;
    }

}
