package com.amos.springcraft.service;


import com.amos.springcraft.dto.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;


@HttpExchange(url = "https://api.restful-api.dev")
public interface ProductService {

    @GetExchange("/objects/{id}")
    Product getProduct(@PathVariable Long id);

    @GetExchange(value = "/objects")
    List<Product> getAllProducts();

    @PostExchange("/objects")
    void saveProduct(Product product);

    @DeleteExchange("/objects/{id}")
    void deleteProduct(@PathVariable Long id);
}
