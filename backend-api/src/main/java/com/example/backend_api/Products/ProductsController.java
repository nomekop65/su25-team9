package com.example.backend_api.Products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Controller
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/Products")
    public String getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String search,
            Model model) {
        int pageSize = 50;
        Page<Product> productPage;
        if (search != null && !search.isEmpty()) {
            productPage = productRepository
                .findByNameContainingIgnoreCase(search, PageRequest.of(page - 1, pageSize));
        } else {
            productPage = productRepository.findAll(PageRequest.of(page - 1, pageSize));
        }
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("search", search);
        return "Products";
    }
}
