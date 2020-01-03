package com.tjh.singleton;

/**
 * lazy-loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却来来了线程不安全的问题
 * 可以通过synchronized解决，但也带来了效率下降
 * 锁的细化？？
 * DCL
 */
public class Single06 {
    private static volatile Single06 INSTANCE;//JIT指令重排

    //阻止外部进行new实例化的渠道
    private Single06() {
    }

    public static Single06 getInstance() {
        if (INSTANCE == null) {
            //双重检查
            synchronized (Single06.class) {
                if (INSTANCE == null) {
                    //延迟一点时间
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Single06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Single06.getInstance().hashCode());
            }).start();
        }
    }
}
