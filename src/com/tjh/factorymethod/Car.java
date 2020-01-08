package com.tjh.factorymethod;

public class Car implements Moveable {
    @Override
    public void go() {
        System.out.println("car go!");
    }
}
