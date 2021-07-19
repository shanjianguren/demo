package com.zhao.thread.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeArray {
    public static final int arraySize = 100;

    public static List<Integer> makeArray() {
        List<Integer> result = new ArrayList<>();
        Random r = new Random(1000);
        System.out.println("----------" + System.currentTimeMillis());
        for (Integer i = 0; i < arraySize; i++) {
            result.add(r.nextInt(1000) + 100);
        }
        for (int a : result) {
            System.out.println("===========" + a);
        }
        System.out.println("----------" + System.currentTimeMillis());
        return result;
    }

    public static Integer[] make() {
        Integer[] result = new Integer[100];
        Random r = new Random(1000);
        System.out.println("----------" + System.currentTimeMillis());
        for (Integer i = 0; i < arraySize; i++) {
            result[i] = r.nextInt(1000) + 1;
        }
        for (int a : result) {
            System.out.println("===========" + a);
        }
        System.out.println("----------" + System.currentTimeMillis());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(makeArray().size());
        List<Integer> list = makeArray();
        int sum = 0;
        Long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        System.out.println((System.currentTimeMillis() - start) + "MS");
        System.out.println(sum);
    }


}
