package com.tjh.observer.v4;

/**
 * 加入多个观察者
 */
class Child {
    private boolean cry = false;
    private Dad d = new Dad();
    private Mom m = new Mom();

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        d.feed();
        m.hug();
    }
}

class Dad {
    public void feed() {
        System.out.println("dad feeding...");
    }
}

class Mom {
    public void hug() {
        System.out.println("mom huging...");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}
