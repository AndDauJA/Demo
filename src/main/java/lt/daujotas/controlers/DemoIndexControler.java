//package lt.daujotas.controlers;
//
//import lt.daujotas.entities.Product;
//import lt.daujotas.services.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class DemoIndexControler {
//    private ProductService productService;
//
//    @Autowired
//    public DemoIndexControler(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/demoindex")
//    public String dataBAseViewForm(Model model) {
//
//
//        model.addAttribute("productList");
//        return "demoindex";
//    }
//
//
//    private Page<Product> filterProductsByDescription(Page<Product> products, String description) {
//        // Filter the existing products by description
//        List<Product> filteredProducts = products.getContent().stream()
//                .filter(product -> product.getDescription().contains(description))
//                .collect(Collectors.toList());
//
//        return new PageImpl<>(filteredProducts, products.getPageable(), filteredProducts.size());
//    }
//
////    private Page<Product> filterProductsByCurrecnId(Page<Product> products, int currencyNo) {
////        // Filter the existing products by description
////        List<Product> filteredProductsByCurrency = products.getContent().stream()
////                .filter(product -> product.getCurrencyId().compareTo(currencyNo)==0)
////                .collect(Collectors.toList());
////
////        return new PageImpl<>(filteredProductsByCurrency, products.getPageable(), filteredProductsByCurrency.size());
////    }
//
//
//
//
//}
