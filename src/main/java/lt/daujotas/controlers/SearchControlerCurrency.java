//package lt.daujotas.controlers;
//
//import lt.daujotas.entities.Product;
//import lt.daujotas.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class SearchControlerCurrency {
//    private ProductService productService;
//
//    @Autowired
//    public SearchControlerCurrency(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/searchdemo")
//    public String dataBAseViewForm(Model model,
//                                   @PageableDefault(size = 20, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable,
//                                   @RequestParam(name = "name", required = false) String name,
//                                   @RequestParam(name = "description", required = false) String description,
//                                   @RequestParam(name = "currencies", required = false) List<Integer> currencyIds) {
//        Page<Product> products;
//        if (currencyIds != null && !currencyIds.isEmpty()) {
//            // Step 1: Filter by currencies
//            products = productService.getProductByCurrencyIds(currencyIds, pageable);
//        } else {
//            // Fetch all products if neither name nor description is provided
//            products = productService.getAllClientsPages(pageable);
//        }
//
//        model.addAttribute("productList", products);
//        return "searchdemo";
//    }
//}
