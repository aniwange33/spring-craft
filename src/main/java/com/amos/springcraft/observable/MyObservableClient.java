package com.amos.springcraft.observable;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyObservableClient  implements Observable{

    private List<Observer> observers = new ArrayList<>();

    private String data;


    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void push() {
        observers.stream().forEach(observer -> observer.update(data));
    }

    @Override
    public void setData(String data) {
        this.data = data;
        push();
    }
}
