package com.amos.springcraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCraftApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCraftApplication.class);

    static void main(String[] args) {
        SpringApplication.run(SpringCraftApplication.class, args);
        log.info("started");
    }

}
