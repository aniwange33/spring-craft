package com.amos.springcraft.web;

import com.amos.springcraft.service.ProductService;
import com.amos.springcraft.dto.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        logger.info("Products fetched");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        logger.info("Fetching Product with id: " + id);
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
