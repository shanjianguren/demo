package com.zhao.thread.Future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleHelper {


    public static class UseCallAble implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int sum=0;
            Random r=new Random();
            for (int i=0;i<100;i++){
                sum += r.nextInt(100);
            }
            System.out.println(sum);
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseCallAble use=new UseCallAble();

        FutureTask task=new FutureTask(use);
        new Thread(task).start();
        Integer i= (Integer) task.get();
        System.out.println("args = [" +i + "]");
    }
}
