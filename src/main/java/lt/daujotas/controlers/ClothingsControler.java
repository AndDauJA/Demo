package lt.daujotas.controlers;


import lt.daujotas.entities.Clothing;
import lt.daujotas.entities.Product;
import lt.daujotas.services.ClothingService;
import lt.daujotas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;


@Controller

public class ClothingsControler {

    private ClothingService clothingService;

    @Autowired
    public ClothingsControler(ClothingService clothingService) {
        this.clothingService = clothingService;
    }

    @GetMapping("/clothing")
    public String dataBAseViewForm(Model model,
                                   @PageableDefault(size = 20, sort = {"brand"}, direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(name = "brand", required = false) String brand,
                                   @RequestParam(name = "size", required = false) List<String> size,
                                   @RequestParam(name = "color", required = false) String color,
                                   @RequestParam(name = "gender", required = false) List<String> gender) {


        Page<Clothing> clothing;
// Filtravimas pagal lyti
        if (gender != null && !gender.isEmpty()) {

            clothing = clothingService.getProductByGender(gender, pageable);
        } else if (size != null && !size.isEmpty()) {

            clothing = clothingService.getProductsBySize(size, pageable);

//           } else if (description != null && !description.isEmpty()) {
//                // Papildomas filtravimas pagal aprašymą, jei nurodytas
//                products = filterProductsByDescription(products, description);
//            }
//        } else if (description != null && !description.isEmpty()) {
//            // Filtravimas pagal aprašymą
//            products = productService.getProductsByDescription(description, pageable);
//            model.addAttribute("searchedDescription", description);
        } else {
            // Grąžinami visi produktai
            clothing = clothingService.getAllClientsPages(pageable);
        }

        model.addAttribute("clothingList", clothing);
        return "clothing";
    }

//    private Page<Clothing> filterProductsByDescription(Page<Clothing> clothing, String size) {
//        // Filter the existing products by description
//        List<Product> filteredProducts = products.getContent().stream()
//                .filter(product -> product.getDescription().contains(description))
//                .collect(Collectors.toList());
//
//        return new PageImpl<>(filteredProducts, products.getPageable(), filteredProducts.size());
//    }

//    private Page<Product> filterProductsByCurrecnId(Page<Product> products, int currencyNo) {
//        // Filter the existing products by description
//        List<Product> filteredProductsByCurrency = products.getContent().stream()
//                .filter(product -> product.getCurrencyId().compareTo(currencyNo) == 0)
//                .collect(Collectors.toList());
//
//        return new PageImpl<>(filteredProductsByCurrency, products.getPageable(), filteredProductsByCurrency.size());
//    }

    @GetMapping("indexdemo")
    public String indexViewForm(Model model,
                                @PageableDefault(size = 20, sort = {"name"},
                                        direction = Sort.Direction.ASC) Pageable pageable) {

        model.addAttribute("productList", pageable);
        return "indexdemo";
    }
}


//@Transactional
//@GetMapping("/searchdemo/{id}/delete")
//public String deleteClient(@PathVariable Long id) {
//    productService.deleteProductById(id);
//    return "redirect:/searchdemo";
//}


