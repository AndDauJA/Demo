package com.mtb.demo.controler;

import java.util.Set;

import com.mtb.demo.entity.Kit;
import com.mtb.demo.service.KitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class KitController {

	private final KitService kitService;

	//TODO: reikia padaryti post o ne get ir siusti dto objecta per request body
	@GetMapping("/clothing")
	public String dataBAseViewForm(
			Model model,
			@PageableDefault(size = 20, sort = {"brand"}, direction = Sort.Direction.ASC) Pageable pageable,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "size", required = false) Set<String> size,
			@RequestParam(name = "color", required = false) Set<String> color,
			@RequestParam(name = "gender", required = false) Set<String> gender) {
		Page<Kit> clothing = Page.empty();
		if (gender != null && !gender.isEmpty()) {
			clothing = kitService.getProductByGender(gender, pageable);
		} /*else if (size != null && !size.isEmpty()) {

			clothing = kitService.getProductsBySize(size, pageable);

		} else if (color != null && !color.isEmpty()) {
			clothing = kitService.getProductsByColor(color, pageable);
		} else {
			clothing = kitService.getAllClientsPages(pageable);
		}*/

		model.addAttribute("clothingList", clothing);
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
