package com.tjh.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离观察者与被观察者
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer {
    @Override
    public void actionOnWakeUp() {
        System.out.println("dad feeding...");
    }
}

class Mom implements Observer {
    @Override
    public void actionOnWakeUp() {
        System.out.println("mom huging...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
