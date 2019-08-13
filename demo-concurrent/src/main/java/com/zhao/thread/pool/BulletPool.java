package com.zhao.thread.pool;

import java.util.LinkedList;

/**
 * 《wait/notify实现生产者和消费者程序》
 *
 * 采用多线程技术，例如wait/notify，设计实现一个符合生产者和消费者问题的程序，对某一个对象（枪膛）进行操作，其最大容量是20颗子弹，生产者线程是一个压入线程，它不断向枪膛中压入子弹，消费者线程是一个射出线程，它不断从枪膛中射出子弹。
 *
 * 请实现上面的程序
 */
public class BulletPool {
    private int size =1;
    private int weight =2;
    Object o=new Object();
    /**
     * 默认弹夹大小 20颗子弹
     */
    public static LinkedList<BulletPool> pool = new LinkedList<>();
    public BulletPool(){

    }
    public static  BulletPool poo=new BulletPool(1,1);


    public BulletPool(int size, int weight) {
        this.size = size;
        this.weight = weight;
    }


    /**
     * 生产子弹 装入弹夹
     */
    public  void makeBullet(){
        synchronized(o){
            try {
                Boolean falg=true;
                while (falg){
                    if(pool.size()>=20 ){
                        System.out.println("线程"+Thread.currentThread().getName()+"等待创建子弹, "+pool.size());
                        o.wait();
                    }else if(pool.size()<20&&falg){
                        System.out.println("线程"+Thread.currentThread().getName()+"创建子弹   "+pool.size());
                        o.notifyAll();
                        pool.addLast(new BulletPool(1,1));
                        falg=false;
                    }
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费子弹
     */
    public void expenseBullet(){
        synchronized (o){
            try {
                while(pool.size()==0){
                    o.wait();
                    System.out.println("线程"+Thread.currentThread().getName()+"d等待消费子弹  "+pool.size());
                }
                if (pool.size()>0){
                    System.out.println("线程"+Thread.currentThread().getName()+"消费子弹  "+pool.size());
                    pool.removeFirst();
                    o.notifyAll();

                }
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<40;i++){
            new Thread(()->poo.makeBullet()).start();

        }
        for (int i=0; i<40;i++){
            new Thread(()->poo.expenseBullet()).start();
        }
        System.out.println("````````````````````````````````````````````````````````````"+pool.size());
    }

}
