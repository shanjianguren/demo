package com.zhao.vip.rw;

import lombok.SneakyThrows;

import java.util.Random;

/**
 *类说明：对商品进行业务的应用
 */
public class BusiApp {
    static final int readWriteRatio = 10;//读写线程的比例
    static final int minthreadCount = 3;//最少线程数
    //读操作
    private static class GetThread implements Runnable{

        private GoodsService goodsService;
        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @SneakyThrows
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for(int i=0;i<100;i++){//操作100次
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName()+"读取商品数据耗时："
             +(System.currentTimeMillis()-start)+"ms");

        }
    }

    //写操做
    private static class SetThread implements Runnable{

        private GoodsService goodsService;
        public SetThread(GoodsService goodsService) {
            this.goodsService =goodsService;
        }

        @SneakyThrows
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Random r = new Random();
            for(int i=0;i<10;i++){//操作10次
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goodsService.setNum(r.nextInt(10));
            }
            System.out.println(Thread.currentThread().getName()
            		+"写商品数据耗时："+(System.currentTimeMillis()-start)+"ms---------");

        }
    }

    public static void main(String[] args) throws InterruptedException {
        GoodsInfo goodsInfo = new GoodsInfo("Cup",100000,10000);
        GoodsService goodsService = new UseSyn(goodsInfo);
        for(int i = 0;i<minthreadCount;i++){
            Thread setT = new Thread(new SetThread(goodsService));
            for(int j=0;j<readWriteRatio;j++) {
                Thread getT = new Thread(new GetThread(goodsService));
                getT.start();           	
            }
            try {
                Thread.sleep(11);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setT.start();
        }
    }
}
