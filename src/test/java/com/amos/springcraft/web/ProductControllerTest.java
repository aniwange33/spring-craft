package com.amos.springcraft.web;

import com.amos.springcraft.dto.Product;
import com.amos.springcraft.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvcTester mockMvcTest;

    @MockitoBean
    private ProductService productService;

    @Test
    @DisplayName("Get All Products - V1")
    void getAllProduct() {
        List<Product> products = List.of(new Product("1", "Mac m4", null), new Product("2", "Product B", null));
        when(productService.getAllProducts()).thenReturn(products);
        assertThat(mockMvcTest.get().uri("/api/v1/products"))
                .hasStatus(HttpStatus.OK)
                .hasContentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .bodyJson()
                .extractingPath("$")
                .asArray()
                .hasSize(2);
    }


    @Test
    void getProductById() {
        Product macM4 = new Product("1", "Mac m4", null);
        when(productService.getProduct(1L)).thenReturn(macM4);
        assertThat(mockMvcTest.get().uri("/api/v1/products/1"))
                .hasStatus(HttpStatus.OK)
                .hasContentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .bodyJson()
                .extractingPath("name")
                .isEqualTo("Mac m4");
    }


}