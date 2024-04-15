package com.mtb.demo.controler;

import java.util.*;
import java.util.stream.Collectors;

import com.mtb.demo.dto.ProductDTO;
import com.mtb.demo.dto.ProductFilterDto;
import com.mtb.demo.entity.Gender;
import com.mtb.demo.entity.Product;
import com.mtb.demo.mapper.ProductDtoMapper;
import com.mtb.demo.service.KitService;
import com.mtb.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class KitController {

    private final KitService kitService;

    @GetMapping("/product")
    public String getProductForm(Model model) {
        Collection<ProductDTO> products = kitService.getAllProducts();
        model.addAttribute("productList", products);
        return "product";
    }

    @PostMapping("/product")
    public String filterProducts(@RequestParam(required = false) List<String> genderFilter, ProductFilterDto productFilterDto, Model model) {
        List<ProductDTO> filteredProducts = kitService.getProductByProductFilter(productFilterDto);
        model.addAttribute("productList", filteredProducts);
        return "product";
    }

    @GetMapping("/search")
    public String searchProductsByName(@RequestParam("name") String name, Model model) {
        List<ProductDTO> products = kitService.searchProductsByName(name);
        model.addAttribute("productList", products);
        return "product";  // Assuming "product" is the view that displays the list of products
    }

}
