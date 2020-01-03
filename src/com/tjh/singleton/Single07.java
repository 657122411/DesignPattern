package com.tjh.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Single07 {
    //阻止外部进行new实例化的渠道
    private Single07() {
    }

    private static class singleHolder {
        private final static Single07 INSTANCE = new Single07();
    }

    public static Single07 getInstance() {
        return singleHolder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Single07.getInstance().hashCode());
            }).start();
        }
    }
}
