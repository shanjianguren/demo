package com.zhao.thread.aqs;

import javax.swing.*;
import java.util.concurrent.locks.Lock;

public class TestReenterSelfLock {
private Lock lock =new ReenterSelfLock();

    public void reenter(int x){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+":递归层级:"+x);
            int y = x - 1;
            if (y==0) return;
            else{
                reenter(y);
            }
        } finally {
            lock.unlock();
        }

    }
    public void test(){
        class  Worker extends  Thread{
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"---开始工作---");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                reenter(3);
            }
        }
        for(int i=0;i<5;i++){
            Worker worker=new Worker();
            worker.start();
        }

        for (int i=0;i<30;i++){
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestReenterSelfLock test=new TestReenterSelfLock();
        test.test();
    }
}
