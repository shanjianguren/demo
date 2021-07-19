package com.zhao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable implements Callable<Integer> {
    int sum = 0;
    @Override
    public Integer call() throws Exception {

        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseCallable useCallable=new UseCallable();
        FutureTask<Integer> futureTask=new FutureTask<>(useCallable);
        Thread t=new Thread();
        t.start();
        System.out.println(futureTask.get());
    }
}
