package me.lramos;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private List<Object> list = new ArrayList<>();

    public Object getLast() {
        return list.remove(0);
    }

    public void notifyTransacao(Object transacao, Boolean isNew) {
        this.list.add(transacao);
        notifyAllObservers(isNew);
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(Boolean isNew) {
        for (Observer observer : observers) {
            observer.update(isNew);
        }
    }

}