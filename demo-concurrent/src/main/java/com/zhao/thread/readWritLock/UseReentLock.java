package com.zhao.thread.readWritLock;


import jdk.internal.dynalink.linker.LinkerServices;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁
 */
public class UseReentLock {

    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static Lock readLock = lock.readLock();
    private static Lock writLock = lock.writeLock();

    public void get1() {

        try {
            readLock.lock();
            Thread.sleep(5);
        } catch (Exception e) {
        } finally {
            readLock.unlock();
        }
    }

    public void set1() {
        try {
            writLock.lock();
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writLock.unlock();
        }
    }


    public synchronized void set1sync() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public synchronized void get1sync() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static class writlock implements Runnable {

        @Override
        public void run() {
            long a = System.currentTimeMillis();
            UseReentLock t = new UseReentLock();
            for (int i = 0; i < 100; i++) {//操作100次
                t.set1sync();
            }
            System.out.println("获取写锁用的时长：" + Thread.currentThread().getName() + "***" + (System.currentTimeMillis() - a) + "ms");
        }
    }

    private static class readlock implements Runnable {
        @Override
        public void run() {
            long a = System.currentTimeMillis();
            UseReentLock t = new UseReentLock();
            for (int i = 0; i < 100; i++) {//操作100次
                t.get1sync();
            }
            System.out.println("获取读锁用的时长：" + Thread.currentThread().getName() + "--" + (System.currentTimeMillis() - a) + "ms");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread wt = new Thread(new writlock());
            wt.start();
            for (int j = 0; j < 3; j++) {

                Thread readT = new Thread(new readlock());
                readT.start();
            }

            Thread.sleep(11);

        }

    }
}
