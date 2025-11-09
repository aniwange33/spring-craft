package com.amos.springcraft.config;

import com.amos.springcraft.service.ProductService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@ImportHttpServices(ProductService.class)
@Configuration(proxyBeanMethods = false)
public class HttpConfig {

}
