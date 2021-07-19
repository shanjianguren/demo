package com.zhao.thread.forkjoin.sort;

import com.zhao.thread.forkjoin.MakeArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 使用forkjoin实现 归并排序
 */
public class ForkjoinSort extends RecursiveTask<Integer[]> {

    private int length = MakeArray.arraySize/ 100;
    private int startIndex;
    private int endIndex;
    private Integer[] src;

    public ForkjoinSort(int startIndex, int endIndex, Integer[] src) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.src = src;
    }

    @Override
    protected Integer[] compute() {
        Integer[] list =MakeArray.make();
        if (endIndex - startIndex < length) {
            for (int i = list.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (list[j] > list[j + 1]) {
                        int temp = list[j + 1];
                        list[j + 1] = list[j];
                        list[j] = temp;
                    }
                }
            }
            return list;
        } else {
            int mid = (startIndex + endIndex) / 2;
            ForkjoinSort left = new ForkjoinSort(startIndex, mid, src);
            ForkjoinSort right = new ForkjoinSort(mid + 1, endIndex, src);
            invokeAll(left, right);
            Integer[] leftarray= left.join();
            Integer[] rightarray= left.join();
            return Sortguibing.merge(leftarray,rightarray);
        }
    }

    public static void main(String[] args) {
        Integer[] list= MakeArray.make();

        Long start=System.currentTimeMillis();
        System.out.println(start);
        ForkjoinSort tast=new ForkjoinSort(0,list.length-1,list);
        ForkJoinPool pool=new ForkJoinPool();
        pool.invoke(tast);
        System.out.println((System.currentTimeMillis()-start)+"MS");
        for (int i=0;i<tast.join().length;i++){
            System.out.println(tast.join()[i]);
        }


    }
}
