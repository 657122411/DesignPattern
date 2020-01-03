package com.tjh.singleton;

/**
 * 同01
 */
public class Single02 {
    private static final Single02 INSTANCE;

    static {
        INSTANCE = new Single02();
    }

    //阻止外部进行new实例化的渠道
    private Single02() {
    }

    public static Single02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Single02 s1 = Single02.getInstance();
        Single02 s2 = Single02.getInstance();
        System.out.println(s1 == s2);
    }
}
