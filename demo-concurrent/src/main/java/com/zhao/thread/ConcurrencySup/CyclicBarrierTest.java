package com.zhao.thread.ConcurrencySup;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * cyclicBarrier 屏障（等待统一执行）
 */
public class CyclicBarrierTest {

    //运行4个线程
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(4,new mergeResult());

    private static ConcurrentHashMap<String,Object> concurrentHashMap=new ConcurrentHashMap<>();
    public void testMake() throws BrokenBarrierException, InterruptedException {
        System.out.println("test-----------Thread id-"+Thread.currentThread().getName());
        concurrentHashMap.put(Thread.currentThread().getName(),Thread.currentThread().getName());
        cyclicBarrier.await();
        System.out.println("等待完成"+Thread.currentThread().getName());
    }

    /**
     * 合并等待线程的结果 如 excel 导出结果合并
     */
    public static class mergeResult implements  Runnable{

        @Override
        public void run() {
            StringBuffer sb=new StringBuffer();
            for (String o :concurrentHashMap.keySet()) {
                sb.append(o);
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<4;i++){
            new Thread(()-> {
                try {
                    new CyclicBarrierTest().testMake();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
