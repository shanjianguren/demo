package com.zhao.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class BulletPoolTest {
    BulletPool pool=new BulletPool();
    static CountDownLatch end;

    private AtomicInteger got;
    private AtomicInteger notGot;
    public BulletPoolTest(AtomicInteger got, AtomicInteger notGot) {
        this.got = got;
        this.notGot = notGot;
    }
    public static void main(String[] args) {

    }
}
