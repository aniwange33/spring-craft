package com.amos.springcraft;

import com.amos.springcraft.observable.Observable;
import com.amos.springcraft.observable.ObservableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static java.lang.IO.println;

@SpringBootApplication
public class SpringCraftApplication  implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringCraftApplication.class);
    @Autowired  private ObservableService observableService;

    static void main(String[] args) {
        SpringApplication.run(SpringCraftApplication.class, args);
        log.info("Hello {}", IO.readln("Enter your name: "));
    }


    @Override
    public void run(String... args) throws Exception {
        observableService.updateObserver();
    }
}
