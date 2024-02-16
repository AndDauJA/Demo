package com.mtb.demo.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mtb.demo.dto.SizeDto;
import com.mtb.demo.entity.Size;
import org.springframework.stereotype.Component;

@Component
public class SizeDtoMapper {

	public SizeDto mapToSizeDto(Size size) {
		return SizeDto.builder()
				.name(size.getValue())
				.build();
	}

	public List<SizeDto> mapToSizeDtos(Collection<Size> sizes) {
		return sizes.stream().map(this::mapToSizeDto).collect(Collectors.toList());
	}

}
