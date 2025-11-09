package com.amos.springcraft.web;

import com.amos.springcraft.dto.Product;
import com.amos.springcraft.web.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final RestClient restClient;
    private final Logger logger = Logger.getLogger(getClass().getName());


    public ProductController(RestClient.Builder builder, @Value("${product-url}") String BASE_URL) {
        logger.info("URL: " + BASE_URL);
        this.restClient = builder.baseUrl(BASE_URL).build();
    }


    @GetMapping("")
    ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = restClient.get().uri("/objects")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        logger.info("Products fetched");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        logger.info("Fetching Product with id: " + id);
        logger.info("Current Thread Name: " + Thread.currentThread().getName());
        return restClient.get().uri("/objects/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (q, r) ->
                {
                    throw new ProductNotFoundException(String.valueOf(id));
                })
                .toEntity(Product.class);
    }
}
