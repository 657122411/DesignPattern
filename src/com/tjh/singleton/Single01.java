package com.tjh.singleton;

/**
 * 饿汉式：
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管是否用到，类加载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class Single01 {
    private static final Single01 INSTANCE = new Single01();

    //阻止外部进行new实例化的渠道
    private Single01() {
    }

    public static Single01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Single01 s1 = Single01.getInstance();
        Single01 s2 = Single01.getInstance();
        System.out.println(s1 == s2);
    }
}
