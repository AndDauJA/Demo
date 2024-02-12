package lt.daujotas.controlers;

import lt.daujotas.entities.Product;
import lt.daujotas.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchControler {
    private ProductService productService;

    @Autowired
    public SearchControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/searchdemo")
    public String dataBAseViewForm(Model model,
                                   @PageableDefault(size = 20, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable,
                                   @RequestParam(name = "name", required = false) String name,
                                   @RequestParam(name = "description", required = false) String description,
                                   @RequestParam(name = "currency", required = false) List<Integer> currencyIds) {


        Page<Product> products;

        if (currencyIds != null && !currencyIds.isEmpty()) {
            // Filtravimas pagal valiutas
            products = productService.getProductByCurrencyIds(currencyIds, pageable);
        }
        if (name != null && !name.isEmpty()) {
            // Filtravimas pagal vardą
            products = productService.getProductByName(name, pageable);
                        model.addAttribute("searchedName", name);

            if (description != null && !description.isEmpty()) {
                // Papildomas filtravimas pagal aprašymą, jei nurodytas
                products = filterProductsByDescription(products, description);
            }
        } else if (description != null && !description.isEmpty()) {
            // Filtravimas pagal aprašymą
            products = productService.getProductsByDescription(description, pageable);
            model.addAttribute("searchedDescription", description);
        } else {
            // Grąžinami visi produktai
            products = productService.getAllClientsPages(pageable);
        }

        model.addAttribute("productList", products);
        return "searchdemo";
    }

    private Page<Product> filterProductsByDescription(Page<Product> products, String description) {
        // Filter the existing products by description
        List<Product> filteredProducts = products.getContent().stream()
                .filter(product -> product.getDescription().contains(description))
                .collect(Collectors.toList());

        return new PageImpl<>(filteredProducts, products.getPageable(), filteredProducts.size());
    }

    private Page<Product> filterProductsByCurrecnId(Page<Product> products, int currencyNo) {
        // Filter the existing products by description
        List<Product> filteredProductsByCurrency = products.getContent().stream()
                .filter(product -> product.getCurrencyId().compareTo(currencyNo)==0)
                .collect(Collectors.toList());

        return new PageImpl<>(filteredProductsByCurrency, products.getPageable(), filteredProductsByCurrency.size());
    }


    @Transactional
    @GetMapping("/searchdemo/{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/searchdemo";
    }


}
