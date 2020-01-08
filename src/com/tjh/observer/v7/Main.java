package com.tjh.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候观察者需要根据事件的具体情况来进行处理
 * 大多数时候，处理事件的时候需要事件源对象
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
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed", this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}

//事件类
class WakeUpEvent {
    long timestamp;
    String loc;
    //!!!源对象
    Child source;

    public WakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}

interface Observer {
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("dad feeding...");
    }
}

class Mom implements Observer {
    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("mom huging...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
