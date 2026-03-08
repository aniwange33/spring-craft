package com.amos.springcraft.observable;

import org.springframework.stereotype.Component;

@Component
public class Observer2  implements Observer {
    @Override
    public void update(String data) {
        System.out.println("printing data from: " + Observer2.class.getName() + " " + data);
    }
}
