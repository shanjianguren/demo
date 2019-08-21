package com.zhao.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 实现自己的独占锁，不可重入
 */
public class SelfLock implements Lock {

    public static class  Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean isHeldExclusively(){
            return getState()==1;
        }

        /**
         * 获得锁
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return  true;
            }
            return  false;
        }

        /**
         * 释放锁
         * @return
         */
        protected boolean tryRelease(){
            if(getState()==0){
                throw  new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition，每个condition都包含了一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    private Sync sync=new Sync();
    @Override
    public void lock() {
        System.out.println(Thread.currentThread().getName()+"lock");
        sync.acquire(1);
        System.out.println(Thread.currentThread().getName()+"locked");
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName()+"-release");
        sync.release(1);
        System.out.println(Thread.currentThread().getName()+"released");
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
