package com.tjh.abstractfactory;

public class MagicFactory extends AbstractFactory {
    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
