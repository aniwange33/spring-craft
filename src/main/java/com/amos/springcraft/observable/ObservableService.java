package com.amos.springcraft.observable;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ObservableService {

    private final Observable  observable;
    private final Map<String , Observer> observers;



    public ObservableService(Observable observable, Map<String, Observer> observers) {
        this.observable = observable;
        this.observers = observers;
        observers.forEach((k,v)->observable.add(v));
    }


    public void  updateObserver() {
        for(int i = 0; i < 10; i++) {
            observable.setData("Amos data: "+i);
        }

    }







}
