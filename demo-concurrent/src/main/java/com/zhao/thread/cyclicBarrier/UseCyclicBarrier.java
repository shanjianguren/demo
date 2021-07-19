package com.zhao.thread.cyclicBarrier;

import lombok.SneakyThrows;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier   {
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public ConcurrentHashMap hashMap=new ConcurrentHashMap();

    private static class SubThread implements Runnable {

        int i=2;
        int j=3;
        public SubThread(int i,int j) {
            this.i=i;
            this.j=j;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"doing");
                int a=i*j;
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+"done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <4 ; i++) {
            Thread t=new Thread(new SubThread(7,2));
            t.start();
        }
    }
}
