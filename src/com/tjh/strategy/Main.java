package com.tjh.strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //int[] a = {9, 5, 4, 6, 2, 4, 1, 7, 8};
        Cat[] a = {new Cat(1, 1), new Cat(3, 3), new Cat(2, 2)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
