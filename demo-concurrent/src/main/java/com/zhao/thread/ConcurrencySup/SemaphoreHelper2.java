package com.zhao.thread.ConcurrencySup;

import java.util.concurrent.Semaphore;

public class SemaphoreHelper2 implements  Runnable{

    private static Semaphore semaphore=new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<50;i++){
            new Thread(new SemaphoreHelper2()).start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("线程名："+Thread.currentThread().getName()+"等待获得许可："+semaphore.getQueueLength()+"--还剩-"+semaphore.availablePermits());
            semaphore.acquire();
            System.out.println("线程名："+Thread.currentThread().getName()+"已经获取许可证"+semaphore.getQueueLength()+"--还剩-"+semaphore.availablePermits());
            Thread.sleep(10);
            semaphore.release();
            System.out.println("线程名："+Thread.currentThread().getName()+"已经释放许可证"+semaphore.getQueueLength()+"--还剩-"+semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
