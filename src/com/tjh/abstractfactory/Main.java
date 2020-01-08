package com.tjh.abstractfactory;

public class Main {
    public static void main(String[] args) {
        //car with ak
        Car c = new Car();
        c.go();
        AK47 ak47 = new AK47();
        ak47.shoot();
        //broom with stick
        Broom broom = new Broom();
        broom.go();
        MagicStick stick = new MagicStick();
        stick.shoot();

        //with abstractfactory
        AbstractFactory f = new ModernFactory();
        Vehicle v = f.createVehicle();
        Weapon w = f.createWeapon();

    }
}
