package com.zhao.thread;

public class Test {

    //wait notifyAll  必须是同一个对象
    private static WaitAndNotifyAll waitn=new WaitAndNotifyAll("shanghai",100);
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(()->{ waitn.waitKm();}).start();
            new Thread(()->{ waitn.waitSite();}).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------------notifyExpress-");
        waitn.notifyExpress();
        System.out.println("---------------notifyExpress-");

    }
}
