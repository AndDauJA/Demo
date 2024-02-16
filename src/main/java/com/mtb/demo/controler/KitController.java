package com.mtb.demo.controler;

import java.util.List;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.dto.ProductFilterDto;
import com.mtb.demo.service.KitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class KitController {

	private final KitService kitService;

	@GetMapping("/clothing")
	public String getClothingForm(Model model) {
		model.addAttribute("productFilterDto", ProductFilterDto.builder().build());
		model.addAttribute("clothingList", ProductDTO.builder().build());
		return "clothing";
	}

	@PostMapping("/clothing/filter")
	public String dataBAseViewForm(Model model,
								   ProductFilterDto productFilterDto) {
		List<ProductDTO> productDtos = kitService.getProductByProductFilter(productFilterDto);
		model.addAttribute("clothingList", productDtos);
		return "clothing";
	}

	@GetMapping("indexdemo")
	public String indexViewForm(
			Model model,
			@PageableDefault(size = 20, sort = {"name"},
							 direction = Sort.Direction.ASC) Pageable pageable) {

		model.addAttribute("productList", pageable);
		return "indexdemo";
	}
}
