package com.zhao.thread.ConcurrencySup;

import java.util.Random;

public class AppTest {
    public static SemaphoreHelper semaphoreTest=new SemaphoreHelper();

    public static class  BuisThread implements Runnable{
        @Override
        public void run() {
            System.out.println("------------"+Thread.currentThread().getName());
            Random r=new Random();
            try {
                Long startTime=System.currentTimeMillis();
                System.out.println("==============="+Thread.currentThread().getName());
                Order order= semaphoreTest.getConnect();//获取链接
                System.out.println("线程"+Thread.currentThread().getName()+",获取链接时长："+(System.currentTimeMillis()-startTime));
                Thread.sleep(500+r.nextInt(1000));
                semaphoreTest.returnOrder(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++){
            new Thread(new BuisThread()).start();
        }
    }
}
