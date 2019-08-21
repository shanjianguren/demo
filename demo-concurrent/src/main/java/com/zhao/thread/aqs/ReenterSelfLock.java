package com.zhao.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReenterSelfLock implements Lock {

    private final Sync sync=new Sync();
    @Override
    public void lock() {
        System.out.println(Thread.currentThread().getName() +"------waiting Lock");
        sync.tryAcquire(0);
        System.out.println(Thread.currentThread().getName()+" =----------Locked");
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return   sync.tryAcquire(0);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName()+"----------ready release");
        sync.tryRelease(1);
        System.out.println(Thread.currentThread().getName()+"----------readied release，已经释放锁");
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public class Sync extends AbstractQueuedSynchronizer {

         protected boolean isHeldExclusively() {
            if (getState() > 1) {
                return true;
            }
            return false;
        }

        //获得锁
        protected boolean tryAcquire(int agrs) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else if (getExclusiveOwnerThread() == Thread.currentThread()) {//如果是线程本身  即 可重入
                setState(getState() + 1);
                return true;
            }
            return false;
        }

        /**
         * 释放锁
         *
         * @return
         */
        protected boolean tryRelease(int agrs) {
            System.out.println(Thread.currentThread().getName()+"------getstate:"+getState());
            if(getState()==0){
                throw  new IllegalMonitorStateException();
            }
            if(getExclusiveOwnerThread()!=Thread.currentThread()){
                throw new IllegalMonitorStateException();
            }
            setState(getState()-1);
            if(getState()==0){
                setExclusiveOwnerThread(null);
                setState(0);
                return  true;
            }
            return false;
        }

        Condition newCondition(){
            return  new ConditionObject();
        }
    }

}
