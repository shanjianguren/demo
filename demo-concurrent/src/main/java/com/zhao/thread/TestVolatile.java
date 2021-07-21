package com.zhao.thread;

import lombok.SneakyThrows;

public class TestVolatile implements Runnable {


    private static volatile int j = 1;

    public TestVolatile() {

    }

    @SneakyThrows
    public  void run() {
        System.out.println(Thread.currentThread().getName() + ",******i=" + j);
        j++;
        System.out.println(Thread.currentThread().getName() + ",######i=" + j);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            TestVolatile testvaltile = new TestVolatile();
            Thread t = new Thread(testvaltile);
            t.start();


        }
    }
}
