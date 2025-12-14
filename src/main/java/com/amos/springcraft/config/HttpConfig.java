package com.amos.springcraft.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@ImportHttpServices(basePackages = "com.amos.springcraft.service")
@Configuration(proxyBeanMethods = false)
public class HttpConfig {

}
