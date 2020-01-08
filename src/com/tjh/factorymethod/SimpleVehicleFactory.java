package com.tjh.factorymethod;

/**
 * 简单工厂的可扩展性不好
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        //do sth: log/authrity
        return new Car();
    }

    public Plane createPlane() {
        //do sth
        return new Plane();
    }
}
