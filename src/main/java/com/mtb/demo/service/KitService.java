package com.mtb.demo.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mtb.demo.entity.Kit;
import com.mtb.demo.entity.Product;
import com.mtb.demo.mapper.KitProductMapper;
import com.mtb.demo.repository.GenderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class KitService {

	private final ProductService productService;
	private final GenderRepository genderRepository;
	private final KitProductMapper kitProductMapper;

	public Page<Kit> getProductByGender(Set<String> genders, Pageable pageable) {
		Page<Product> productByGenders = productService.getProductByGenders(genderRepository.findDistinctByCodeIn(genders), pageable);
		List<Kit> kits = productByGenders.getContent().stream()
				.map(kitProductMapper::mapTo)
				.collect(Collectors.toList());
		return new PageImpl<>(kits, pageable, productByGenders.getTotalElements());
	}

}
