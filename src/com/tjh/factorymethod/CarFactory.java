package com.tjh.factorymethod;

public class CarFactory {
    public Car create() {
        System.out.println("a car created!");
        return new Car();
    }

    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();
    }
}
