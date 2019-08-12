package com.zhao.thread;

public class WaitAndNotifyAll {

    private String site="shanghai";
    private int km=100;
    public WaitAndNotifyAll(){

    }

    private static WaitAndNotifyAll waitn=new WaitAndNotifyAll("shanghai",100);
    public WaitAndNotifyAll(String site, int km) {
        this.site = site;
        this.km = km;
    }

    public  synchronized void waitSite(){
            while (this.site.equals("shanghai")){
                try {
                    wait();
                    System.out.println("-----------------线程等待");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        System.out.println("-----------------waitSite");
    }

    //地址变更  唤醒线程 通知
    public synchronized void notifyExpress(){
        this.site="jingzhou";
        this.km=2000;
        notifyAll();
    }

    public synchronized void waitKm(){
            while (this.km<200){

                try {
                    wait();
                    System.out.println("公里路小于200");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("-----------------waitKm");
    }




    public static void main(String[] args) {
           for (int i=0;i<5;i++){
               new Thread(()->{waitn.waitKm();}).start();
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
