package demo;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        int newCap, newThr = 0;
        int oldCap = 12;
        System.out.println(newCap = oldCap << 1);
        System.out.println(1 << 30);
        System.out.println(1 << 4);
        System.out.println(oldCap >= (1 << 4));
        System.out.println((newCap = oldCap << 1) < (1 << 30) && oldCap >= (1 << 4));
    }
}
