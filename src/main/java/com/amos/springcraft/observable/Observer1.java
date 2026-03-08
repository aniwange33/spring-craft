package com.amos.springcraft.observable;

import org.springframework.stereotype.Component;

@Component
public class Observer1 implements Observer {
    @Override
    public void update(String data) {
        System.out.println("printing data from: " + Observer1.class.getName() + " " + data);
    }
}
