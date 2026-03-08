package com.amos.springcraft.observable;

public interface Observable {

    void add(Observer observer);
    void remove(Observer observer);
    void push();
    void setData(String data);
}
