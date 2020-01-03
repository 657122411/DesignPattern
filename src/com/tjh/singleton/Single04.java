package com.tjh.singleton;

/**
 * lazy-loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却来来了线程不安全的问题
 * 可以通过synchronized解决，但也带来了效率下降
 */
public class Single04 {
    private static Single04 INSTANCE;

    //阻止外部进行new实例化的渠道
    private Single04() {
    }

    public static synchronized Single04 getInstance() {
        if (INSTANCE == null) {
            //延迟一点时间
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Single04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Single04.getInstance().hashCode());
            }).start();
        }
    }
}
