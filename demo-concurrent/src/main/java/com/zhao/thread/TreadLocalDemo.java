package com.zhao.thread;

public class TreadLocalDemo implements Runnable {

    private int i = 1;
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        protected Integer initialValue() {
            return 1;
        }
    };

    public TreadLocalDemo(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            TreadLocalDemo d = new TreadLocalDemo(1);
            Thread t = new Thread(d);
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + i);
        Integer s = threadLocal.get();
        s = s + 1;
        threadLocal.set(s);
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }
}
