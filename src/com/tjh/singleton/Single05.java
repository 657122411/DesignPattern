package com.tjh.singleton;

/**
 * lazy-loading
 * 懒汉式
 * 虽然达到了按需初始化的目的，但却来来了线程不安全的问题
 * 可以通过synchronized解决，但也带来了效率下降
 * 锁的细化？？
 */
public class Single05 {
    private static Single05 INSTANCE;

    //阻止外部进行new实例化的渠道
    private Single05() {
    }

    public static Single05 getInstance() {
        if (INSTANCE == null) {
            //妄图通过减小同步代码块的方式提高效率，然而不可行
            synchronized(Single05.class){
                //延迟一点时间
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Single05();
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
                System.out.println(Single05.getInstance().hashCode());
            }).start();
        }
    }
}
