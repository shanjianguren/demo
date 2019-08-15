package com.zhao.thread.ConcurrencySup;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 流控场景  限流
 * 作用是控制线程的并发数量
 */
public class SemaphoreHelper {

    public static LinkedList<Order> linkedList=new LinkedList<>();
    public Semaphore used,unUsed;
    public static Integer count=10;
    static {
        for (int i=0;i<count;i++){
            linkedList.addLast(new Order());
        }
    }
    public SemaphoreHelper(){
        used=new Semaphore(10);//容量大小
        unUsed=new Semaphore(0);//已用多少
    }

    //使用完毕 把容量还给池
    public void returnOrder(Order order) throws InterruptedException {
        if(order!=null){
            System.out.println("线程名:"+Thread.currentThread().getName()+",等待消费订单,有几个在等待线程，即超出几个"
                    +used.getQueueLength()+",可使用的许可证数量,还差多少到规定的数量"+used
            .availablePermits());
            unUsed.acquire();// 锁定许可证
            synchronized (linkedList){
                linkedList.addLast(order);
            }
            used.release();//释放许可证
        }
    }

    /**
     * 从池中拿取链接
     * Semaphore中包含初始化时固定个数的许可，在进行操作的时候，需要先acquire获取到许可，才可以继续执行任务，如果获取失败，则进入阻塞；处理完成之后需要release释放许可。
     * @return
     */
    public Order getConnect() throws InterruptedException {
        System.out.println("getConnect");
        used.acquire();//确定链接池中还有没有 链接，需要先acquire获取到许可
        Order order;
        System.out.println("getConnect1");
        synchronized (linkedList){
            order= linkedList.removeFirst();
        }
        unUsed.release();
        return  order;
    }


}
