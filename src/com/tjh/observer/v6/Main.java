package com.tjh.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * 很多时候观察者需要根据事件的具体情况来进行处理
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
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");
        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}

//事件类
class WakeUpEvent {
    long timestamp;
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
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
