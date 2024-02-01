package lt.daujotas;

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

import java.util.List;
import java.util.Optional;
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
                                   @RequestParam(name = "description", required = false) String description) {
        Page<Product> products;

        if (name != null && !name.isEmpty()) {
            // Step 1: Search by name
            products = productService.getProductByName(name, pageable);
            model.addAttribute("searchedName", name); // Add searched name to highlight in the UI

            if (description != null && !description.isEmpty()) {
                // Step 2: Further filter by description if provided
                products = filterProductsByDescription(products, description);
            }
        } else if (description != null && !description.isEmpty()) {
            // If name is not provided, search by description
            products = productService.getProductsByDescription(description, pageable);
            model.addAttribute("searchedDescription", description); // Add searched description to highlight in the UI
        } else {
            // Fetch all products if neither name nor description is provided
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


    @Transactional
    @GetMapping("/searchdemo/{id}/delete")
    public String deleteClient(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/searchdemo";
    }


}
