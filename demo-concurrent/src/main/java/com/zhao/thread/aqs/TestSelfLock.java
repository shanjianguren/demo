package com.zhao.thread.aqs;

import java.util.concurrent.locks.Lock;

public class TestSelfLock {
    final Lock lock=new SelfLock();
    private void test()  {

        class  Worker extends Thread{

            public void run() {
                try{
                    lock.lock();
                    System.out.println("线程名："+Thread.currentThread().getName());
                        Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }

        for (int i=0;i<4;i++){
            new Worker().start();
        }
        for (int i=0;i<4;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestSelfLock lock=new TestSelfLock();
        lock.test();
    }

}
