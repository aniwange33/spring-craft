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
@RequestMapping(value = "api/v{version}/products")
public class ProductController {
    private final ProductService productService;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(version = "1")
    ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        logger.info("Products fetched 1");
        return ResponseEntity.ok(products);
    }

    @GetMapping(version = "2")
    ResponseEntity<List<Product>> getAllProduct2() {
        List<Product> products = productService.getAllProducts();
        logger.info("Products fetched 2");
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}", version = "1")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        logger.info("Fetching v1 Product with id: " + id);
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/{id}", version = "2")
    public ResponseEntity<Product> getProductById2(@PathVariable Long id) {
        logger.info("Fetching v2 Product with id: " + id);
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
