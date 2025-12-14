package com.amos.springcraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.IO.println;

@SpringBootApplication
public class SpringCraftApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCraftApplication.class);

    static void main(String[] args) {
        SpringApplication.run(SpringCraftApplication.class, args);
        log.info("Hello {}", IO.readln("Enter your name: "));
    }

}
