package com.tjh.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化
 * （枚举类没有构造方法，拿到.class序列化 newInstance也行不通）
 */
public enum Single08 {
    //枚举单例
    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Single08.INSTANCE.hashCode());
            }).start();
        }
    }
}
