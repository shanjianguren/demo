package com.zhao.vip;

import java.sql.Connection;
import java.util.LinkedList;

/**
 *类说明：连接池的实现
 */
public class DBPool {

    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    public DBPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(SqlConnectImpl.fetchConnection());
            }
        }
    }

    /**
     * 释放连接，通知其他等待连接的线程
     * @param connection
     */
    public void releaseConnection(Connection connection) throws InterruptedException {
        if (connection != null) {
            //TODO
            synchronized (pool){
                pool.addLast(connection);
                Thread.sleep(10);
                pool.notifyAll();
            }
        }
    }

    // 在mills内无法获取到连接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        //TODO
        synchronized (pool){
            //永不超时
            if(mills<0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                //超时时刻
                long future=System.currentTimeMillis()+mills;
                //等待时长
                long remaining=mills;
                while (pool.isEmpty()&&remaining>0){
                    pool.wait(remaining);
                    //唤醒一次，重新计算时长
                    remaining=future-System.currentTimeMillis();
                }
                Connection connection=null;
                if(!pool.isEmpty()){
                    connection= pool.removeFirst();
                }
                return connection;
            }
        }
    }
}
